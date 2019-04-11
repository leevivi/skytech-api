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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
    public List findAllVouchers(String accountSid) {
        Map<String, Object> memberInfoData = new HashMap<>();
        memberInfoData = checkMembers(memberInfoData, accountSid);
        List<MemberInfo> memberList = new ArrayList<>();
        List<MyVouchers> allList = new ArrayList();
        int memberId = 0;
        int companyId = 0;
        int storesId = 0;
        try {
            memberList = (List<MemberInfo>) memberInfoData.get("memberInfoList");
            for (MemberInfo memberInfo :memberList) {
                MyVouchers myVouchers = new MyVouchers();
                memberId = memberInfo.getMemberId();
                companyId = memberInfo.getCompanyId();
                storesId = memberInfo.getStoresId();
                List<Vouchers> list = new ArrayList<>();
                String now = DateUtil.formatmiddledatestr(new Date());
                TCouponMembersExample tCouponMembersExample = new TCouponMembersExample();
                tCouponMembersExample.createCriteria().andMemberidEqualTo(memberId).andValidityperiodGreaterThanOrEqualTo(now);
                List<TCouponMembers> tCouponMembers = tCouponMembersMapper.selectByExample(tCouponMembersExample);
                for (TCouponMembers tcm :tCouponMembers) {
                    TCouponExample tCouponExample = new TCouponExample();
                    tCouponExample.createCriteria().andIdEqualTo(tcm.getCouponid());
                    List<TCoupon> tCoupons = tCouponMapper.selectByExample(tCouponExample);

                    Vouchers vouchers = new Vouchers();
                    vouchers.setVouchersName(tCoupons.get(0).getCouponname());
                    vouchers.setAvailableClub("This stores use only");
                    OrgStores orgStores = orgStoresMapper.selectByPrimaryKey(tCoupons.get(0).getStoresid());
                    myVouchers.setClubId(orgStores.getId());
                    myVouchers.setClubName(orgStores.getStoresname());
                    //通过有效时间补全当月日期2019-04-01-2019-04-30
                    vouchers.setValidityTime(DateUtil.getHeadAndEndDateForMonth(tcm.getValidityperiod()));
                    list.add(vouchers);
                    myVouchers.setVouchersList(list);
                }
                allList.add(myVouchers);
            }
        }catch (Exception e){
            return allList;
        }

        return allList;
    }


    public Map<String,Object> checkMembers(Map<String, Object> data, String accountSid) {

        List<Object> memberInfoList = new ArrayList<>();
        Account account = accountMapper.selectByPrimaryKey(accountSid);
        TMemberExample tMemberExample = new TMemberExample();
        tMemberExample.createCriteria().andAppuserEqualTo(account.getEmail());
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
