package com.skytech.api.service.impl;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.core.service.impl.GenericOneServiceImpl;
import com.skytech.api.core.utils.DateUtil;
import com.skytech.api.mapper.*;
import com.skytech.api.model.*;
import com.skytech.api.model.base.BaseTCouponMembers;
import com.skytech.api.model.base.BaseTCouponMembersExample;
import com.skytech.api.service.MyVouchersService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by LiWei on 2019/4/5.
 */
@Service("myVouchersService")
public class MyVouchersServiceImpl extends GenericOneServiceImpl<TCouponMembers,TCouponMembersExample,Integer> implements MyVouchersService{

    @Autowired
    private TCouponMembersMapper tCouponMembersMapper;
    @Autowired
    private TCourseCouponMapper tCourseCouponMapper;
    @Autowired
    private TCourseMapper tCourseMapper;
    @Autowired
    private OrgStoresMapper orgStoresMapper;
    @Autowired
    private OrgCompanyMapper orgCompanyMapper;
    @Autowired
    private TCouponMapper tCouponMapper;
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private TMemberMapper tMemberMapper;


    @Override
    protected GenericOneMapper<TCouponMembers, TCouponMembersExample, Integer> getGenericOneMapper() {
        return this.tCouponMembersMapper;
    }

    @Override
    public Pagination<TCouponMembers> findForPage(int memberId, int page, int limit) {

        TCouponMembersExample tCouponMembersExample = new TCouponMembersExample();
        BaseTCouponMembersExample.Criteria criteria = tCouponMembersExample.createCriteria();
        criteria.andMemberidEqualTo(memberId);
        Pagination<TCouponMembers> pagination = this.queryByPage(tCouponMembersExample, (page - 1) * limit, limit, "createTime desc");

        return pagination;
    }

    @Override
    public Map<String,Object> findAllVouchers(String accountSid) {
        Map<String, Object> memberInfoData = new HashMap<>();
        memberInfoData = checkMembers(memberInfoData, accountSid);
        List<MemberInfo> memberList = new ArrayList<>();
        Map<String, Object> map = new HashMap<String, Object>();
        Map<Integer, Object> companyMap = new HashMap<Integer, Object>();
        List<Vouchers> allCompanyCoupon = new ArrayList<Vouchers>();
        List<MyVouchers> allList = new ArrayList();
        List<Vouchers> vouchersList = new ArrayList<>();
        int memberId = 0;
        int companyId = 0;
        int storesId = 0;
        try {
            memberList = (List<MemberInfo>) memberInfoData.get("memberInfoList");
            //根据公司和门店去重
            List<MemberInfo> distinctClass = memberList.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(o -> o.getCompanyId() + ";" + o.getStoresId()))), ArrayList::new));

            for (MemberInfo memberInfo :distinctClass) {
                if(companyMap.get(memberInfo.getCompanyId()) == null) {
                    companyMap.put(memberInfo.getCompanyId(), "t");
                    TMember member = tMemberMapper.selectByPrimaryKey(memberInfo.getMemberId());

                    List<TCouponMembers> list = tCouponMembersMapper.findByValidityPeriod(member.getAppuser());

                    if(list.isEmpty()) {
                        list = new ArrayList<TCouponMembers>();
                    } else {
                        for (TCouponMembers tCouponMembers : list) {
                            TCouponExample tCouponExample = new TCouponExample();
                            tCouponExample.createCriteria().andIdEqualTo(tCouponMembers.getCouponid());
                            List<TCoupon> tCoupons = tCouponMapper.selectByExample(tCouponExample);

//                            OrgCompany company = orgStoresMapper
                            Vouchers vouchers = new Vouchers();

                            vouchers.setVouchersName(tCoupons.get(0).getCouponname());
                            vouchers.setAvailableClub("Suitable for all");
                            OrgCompany company = orgCompanyMapper.selectByPrimaryKey(memberInfo.getCompanyId());
                            vouchers.setCompanyName(company.getCompanyname());
                            //通过有效时间补全当月日期2019-04-01-2019-04-30
                            vouchers.setValidityTime(DateUtil.getHeadAndEndDateForMonth(tCouponMembers.getValidityperiod()));

                            allCompanyCoupon.add(vouchers);
                        }
                    }
                }
                MyVouchers myVouchers = new MyVouchers();
                memberId = memberInfo.getMemberId();
                companyId = memberInfo.getCompanyId();
                storesId = memberInfo.getStoresId();
                OrgStores orgStores = orgStoresMapper.selectByPrimaryKey(storesId);
                myVouchers.setClubId(orgStores.getId());
                myVouchers.setClubName(orgStores.getStoresname());

                String now = DateUtil.formatmiddledatestr(new Date());
                TCouponMembersExample tCouponMembersExample = new TCouponMembersExample();
                tCouponMembersExample.createCriteria().andMemberidEqualTo(memberId).andValidityperiodGreaterThanOrEqualTo(now).andCouponidEqualTo(1).andStatusEqualTo(0);
                List<TCouponMembers> tCouponMembers = tCouponMembersMapper.selectByExample(tCouponMembersExample);
                for (TCouponMembers tcm :tCouponMembers) {
                    TCouponExample tCouponExample = new TCouponExample();
                    tCouponExample.createCriteria().andIdEqualTo(tcm.getCouponid());
                    List<TCoupon> tCoupons = tCouponMapper.selectByExample(tCouponExample);
                    Vouchers vouchers = new Vouchers();
                    vouchers.setVouchersName(tCoupons.get(0).getCouponname());
                    vouchers.setAvailableClub("This stores use only");

                    //通过有效时间补全当月日期2019-04-01-2019-04-30
                    vouchers.setValidityTime(DateUtil.getHeadAndEndDateForMonth(tcm.getValidityperiod()));
                    vouchersList.add(vouchers);
                    myVouchers.setVouchersList(vouchersList);
                }
                allList.add(myVouchers);
            }
            map.put("stores", allList);
            map.put("company", allCompanyCoupon);
        }catch (Exception e){
            return map;
        }

        return map;
    }


    public Map<String,Object> checkMembers(Map<String, Object> data, String accountSid) {

        List<Object> memberInfoList = new ArrayList<>();
        Account account = accountMapper.selectByPrimaryKey(accountSid);
        TMemberExample tMemberExample = new TMemberExample();
        tMemberExample.createCriteria().andAppuserEqualTo(account.getEmail()).andIsoverdueEqualTo(0);
        List<TMember> tMembers = tMemberMapper.selectByExample(tMemberExample);
        if(tMembers.isEmpty()||tMembers.get(0).getCompanyid()==null||tMembers.get(0).getStoresid()==null){
            List<TCourse> list = new ArrayList<>();
            data.put("data", list);
            return data;
        }
        for (TMember tMember :tMembers) {
            MemberInfo memberInfo = new MemberInfo();
            memberInfo.setMemberId(tMember.getId());
            memberInfo.setCompanyId(tMember.getCompanyid());
            memberInfo.setStoresId(tMember.getStoresid());
            memberInfoList.add(memberInfo);

        }
        data.put("memberInfoList",memberInfoList);
        return data;
    }

}
