package com.dukz.test;

import com.dukz.sqlparser.SqlParser;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Arvin Du
 * @version 1.0
 * @date 2025/03/18
 */
public class SqlParserTest {

    public static final String sqlTmp = "with vend_list as (\n" +
            "SELECT distinct vend_no,cast(null as int) as vpl_no\n" +
            "\tfrom dim_${regionCode}.dim_disty_v_pm_vpc_matrix_view\n" +
            "\twhere pm_id =#{userId}\n" +
            "\tand pm_role = #{userRole}\n" +
            "\tand vpl_no =-1\n" +
            "\tand vend_no is not null\n" +
            "<if test=\"sysPrimaryAssigned\">\n" +
            "\tand is_primary='Y'\n" +
            "\tand is_backup='N'\n" +
            "</if>\n" +
            "),\n" +
            "vpl_list as(\n" +
            "SELECT distinct cast(null as int) as vend_no,vpl_no\n" +
            "\tfrom dim_${regionCode}.dim_disty_v_pm_vpc_matrix_view\n" +
            "\twhere pm_id =#{userId}\n" +
            "\tand pm_role = #{userRole}\n" +
            "\tand vpl_no != -1\n" +
            "\tand vpl_no is not null\n" +
            "\tand vend_no not in (select vend_no from vend_list)\n" +
            "<if test=\"sysPrimaryAssigned\">\n" +
            "\tand is_primary='Y'\n" +
            "\tand is_backup='N'\n" +
            "</if>\n" +
            "),\n" +
            "vendVpl as (\n" +
            "SELECT vend_no,vpl_no from vend_list\n" +
            "union\n" +
            "SELECT vend_no,vpl_no from vpl_list\n" +
            "),\n" +
            "vendVplMap as (\n" +
            "select cast(null as int) as vendNo,isnull(alt_vpl_no, vp.vpl_no) as vplNo\n" +
            "FROM vpl_list as br,dim_${regionCode}.dim_pub_vpl_info vp\n" +
            "WHERE vp.vpl_no  <![CDATA[<>]]>  vp.alt_vpl_no\n" +
            "\tAND br.vpl_no = vp.vpl_no\n" +
            "\tAND vp.vpl_no  <![CDATA[<>]]>  - 1\n" +
            "\tand vp.alt_vpl_no is not null\n" +
            "UNION\n" +
            "select isnull(alt_vend_no, vp.vend_no) as vendNo,cast(null as int) as vplNo\n" +
            "FROM vend_list as br,dim_${regionCode}.dim_pub_vpl_info vp\n" +
            "WHERE vp.vend_no  <![CDATA[<>]]>  vp.alt_vend_no\n" +
            "\tAND br.vend_no = vp.vend_no\n" +
            "\tand vp.alt_vpl_no is null\n" +
            "UNION\n" +
            "select cast(null as int) as vendNo,isnull(alt_vpl_no, vp.vpl_no) as vplNo\n" +
            "FROM vend_list as br,dim_${regionCode}.dim_pub_vpl_info vp\n" +
            "WHERE vp.vend_no  <![CDATA[<>]]>  vp.alt_vend_no\n" +
            "\tAND br.vend_no = vp.vend_no\n" +
            "\tand vp.alt_vpl_no is not null\n" +
            "),\n" +
            "altVendVpl as (\n" +
            "select distinct br.vend_no,br.vpl_no\n" +
            "FROM vpl_list as br,dim_${regionCode}.dim_pub_vpl_info vp\n" +
            "WHERE vp.vpl_no  <![CDATA[<>]]>  vp.alt_vpl_no\n" +
            "\tAND br.vpl_no = vp.vpl_no\n" +
            "\tAND vp.vpl_no  <![CDATA[<>]]>  - 1\n" +
            "\tand vp.alt_vpl_no is not null\n" +
            "UNION\n" +
            "select distinct br.vend_no,br.vpl_no\n" +
            "FROM vend_list as br,dim_${regionCode}.dim_pub_vpl_info vp\n" +
            "WHERE vp.vend_no  <![CDATA[<>]]>  vp.alt_vend_no\n" +
            "\tAND br.vend_no = vp.vend_no\n" +
            "\tand vp.alt_vpl_no is null\n" +
            "UNION\n" +
            "select distinct br.vend_no,br.vpl_no\n" +
            "FROM vend_list as br,dim_${regionCode}.dim_pub_vpl_info vp\n" +
            "WHERE vp.vend_no  <![CDATA[<>]]>  vp.alt_vend_no\n" +
            "\tAND br.vend_no = vp.vend_no\n" +
            "\tand vp.alt_vpl_no is not null\n" +
            "),\n" +
            "noAltVendVpl as(\n" +
            "select distinct vend_no as vendNo,cast(null as int) as vplNo\n" +
            "FROM vendVpl as br\n" +
            "where br.vend_no not in (select distinct vend_no from altVendVpl where vend_no is not null)\n" +
            "and br.vend_no is not null\n" +
            "union\n" +
            "select distinct cast(null as int) as vendNo,vpl_no as vplNo\n" +
            "FROM vendVpl as br\n" +
            "where br.vpl_no not in (select distinct vpl_no from altVendVpl where vpl_no is not null)\n" +
            "and br.vpl_no is not null\n" +
            "),\n" +
            "resultVendVpl as (\n" +
            "\tselect vendNo,vplNo from vendVplMap\n" +
            "\tunion\n" +
            "\tselect vendNo,vplNo from noAltVendVpl\n" +
            "<if test=\"!sysPrimaryAssigned\">\n" +
            "\tunion\n" +
            "\tselect distinct vend_no as vendNo,cast(null as int) as vplNo\n" +
            "\tfrom dim_${regionCode}.dim_pub_vendor_info dpvi\n" +
            "\twhere vend_seg_code in (\n" +
            "\t\tselect distinct value_c\n" +
            "\t\tfrom dim_${regionCode}.dim_disty_brpt_virtual_spy \n" +
            "\t\twhere spy_type='PM' and sub_cat='SEG' and userid =#{userId}\n" +
            "\t)\n" +
            "\tunion\n" +
            "\tselect distinct value_i as vendNo,cast(null as int) as vplNo\n" +
            "\tfrom dim_${regionCode}.dim_disty_brpt_virtual_spy \n" +
            "\twhere spy_type='PM' and sub_cat='VEND' and userid =#{userId}\n" +
            "</if>\n" +
            ")\n" +
            "select distinct vendNo,vplNo from resultVendVpl";

    public static void main(String[] args) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("regionCode", "us");
        map.put("userId", 146);
        map.put("userRole", "PM");
        SqlParser parser = new SqlParser();
        System.out.println(parser.parser(sqlTmp, map));
        System.out.println(parser.getParams());
    }
}
