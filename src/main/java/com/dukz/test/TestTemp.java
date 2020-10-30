package com.dukz.test;

import java.util.HashMap;

/**
 * @ClassName TestTemp
 * @Description TODO
 * @Author dukz
 * @Date 2020-06-23
 * @Version 1.0
 */
public class TestTemp {
    public static void main(String[] args) {
        String s1 = "id, organization_id, socialcode, organizationname, bussinesstype, orgtype, mantype, postcode, address, linkman, tel, officehour, weblinks, longitude, latitude, bussinessscope, leader, introduce, guidance, isbinding, community, street, district, activityrange, donationaccount, depositbank, accountholder, socialorganizregistration, isqualification, certificatenumber, accepteditemslist, servicesavailable, rescuestationduty, helpedpersonnel, approvalagenciesname, isforpublic, is_delete, create_by, create_time, update_by, update_time, locationguide, established, onlineconsultaddress, onlineviewaddress, chargingsection, areacovered, occupancy, bednumber, organizationnature, deputyseniortitles, appointmentaddress, actualusedbed, organizationlevel, bussinesscontent, applicationprocess, rescuersstation, facilities, serviceobject, auxiliaryequipment, chargingstandard, financingproject, donationprocess, onlinedonationlink, availablebussinessmatters, chargeperson, charityproject";
        String s2 = "#{id,jdbcType=VARCHAR}, #{organizationId,jdbcType=VARCHAR}, #{socialcode,jdbcType=VARCHAR}, #{organizationname,jdbcType=VARCHAR}, #{bussinesstype,jdbcType=VARCHAR}, #{orgtype,jdbcType=VARCHAR}, #{mantype,jdbcType=VARCHAR}, #{postcode,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, #{linkman,jdbcType=VARCHAR}, #{tel,jdbcType=VARCHAR}, #{officehour,jdbcType=VARCHAR}, #{weblinks,jdbcType=VARCHAR}, #{longitude,jdbcType=VARCHAR}, #{latitude,jdbcType=VARCHAR}, #{bussinessscope,jdbcType=VARCHAR}, #{leader,jdbcType=VARCHAR}, #{introduce,jdbcType=OTHER}, #{guidance,jdbcType=OTHER}, #{isbinding,jdbcType=INTEGER}, #{community,jdbcType=VARCHAR}, #{street,jdbcType=VARCHAR}, #{district,jdbcType=VARCHAR}, #{activityrange,jdbcType=VARCHAR}, #{donationaccount,jdbcType=VARCHAR}, #{depositbank,jdbcType=VARCHAR}, #{accountholder,jdbcType=VARCHAR}, #{socialorganizregistration,jdbcType=VARCHAR}, #{isqualification,jdbcType=VARCHAR}, #{certificatenumber,jdbcType=VARCHAR}, #{accepteditemslist,jdbcType=VARCHAR}, #{servicesavailable,jdbcType=VARCHAR}, #{rescuestationduty,jdbcType=VARCHAR}, #{helpedpersonnel,jdbcType=VARCHAR}, #{approvalagenciesname,jdbcType=VARCHAR}, #{isforpublic,jdbcType=INTEGER}, #{isDelete,jdbcType=INTEGER}, #{createBy,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP}, #{locationguide,jdbcType=VARCHAR}, #{established,jdbcType=TIMESTAMP}, #{onlineconsultaddress,jdbcType=VARCHAR}, #{onlineviewaddress,jdbcType=VARCHAR}, #{chargingsection,jdbcType=VARCHAR}, #{areacovered,jdbcType=NUMERIC}, #{occupancy,jdbcType=INTEGER}, #{bednumber,jdbcType=INTEGER}, #{organizationnature,jdbcType=VARCHAR}, #{deputyseniortitles,jdbcType=INTEGER}, #{appointmentaddress,jdbcType=VARCHAR}, #{actualusedbed,jdbcType=INTEGER}, #{organizationlevel,jdbcType=VARCHAR}, #{bussinesscontent,jdbcType=VARCHAR}, #{applicationprocess,jdbcType=VARCHAR}, #{rescuersstation,jdbcType=INTEGER}, #{facilities,jdbcType=VARCHAR}, #{serviceobject,jdbcType=VARCHAR}, #{auxiliaryequipment,jdbcType=VARCHAR}, #{chargingstandard,jdbcType=VARCHAR}, #{financingproject,jdbcType=VARCHAR}, #{donationprocess,jdbcType=VARCHAR}, #{onlinedonationlink,jdbcType=VARCHAR}, #{availablebussinessmatters,jdbcType=VARCHAR}, #{chargeperson,jdbcType=VARCHAR}, #{charityproject,jdbcType=VARCHAR}, #{stuff,jdbcType=INTEGER},#{registers,jdbcType=INTEGER},#{upsexty,jdbcType=INTEGER},#{starlevel,jdbcType=VARCHAR},#{capacity,jdbcType=INTEGER},#{certificateofftime,jdbcType=TIMESTAMP}";
        String[] split1 = s1.split(", ");
        String[] split2 = s2.split(", ");
        System.out.println(split1.length);
        System.out.println(split2.length);
        for(int i=0;i<split1.length;i++){
            System.out.println(split1[i]+"---"+split2[i]);
        }
    }
}
