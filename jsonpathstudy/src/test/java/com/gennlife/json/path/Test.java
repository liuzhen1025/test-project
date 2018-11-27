/**
 * copyRight
 */
package com.gennlife.json.path;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/3/13
 * Time: 10:23
 */
public class Test {
    private GroupSplitService splitService = new GroupSplitServiceImpl();
    private String patients = "{\n" +
            "\t\"visits\": [{\n" +
            "\t\t\"inspection_reports\": [{\n" +
            "\t\t\t\t\"SPECIMEN_NAME\": \"标志物血清(粉)\",\n" +
            "\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XK\",\n" +
            "\t\t\t\t\"VISIT_SN\": \"vis_4785faa009a6b4af3514a84cee607ad0\",\n" +
            "\t\t\t\t\"APPLY_SN\": \"19601000004XK\",\n" +
            "\t\t\t\t\"SUBMITTING_DEPARTMENT\": \"简易门诊\",\n" +
            "\t\t\t\t\"INSPECTION_NAME\": \"肿瘤筛查常规(男)(门特)\",\n" +
            "\t\t\t\t\"PATIENT_SN\": \"pat_b72e8c3d9abcec9e5e8ecaf2c2ab0458\",\n" +
            "\t\t\t\t\"ORDER_TIME\": \"2017-03-03 15:12:00\",\n" +
            "\t\t\t\t\"sub_inspection\": [{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XK\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"甲胎蛋白\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"1.73\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"AFP\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"0--20\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"μg/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XK\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"糖类抗原125\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"8.13\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"CA-125\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"0--35\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"U/ml\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XK\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"糖类抗原19-9\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"10.97\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"CA19-9\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"0--39\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"U/ml\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XK\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"糖类抗原CA72-4\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"0.700\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"CA72-4\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"0--6\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"U/ml\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XK\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"癌胚抗原\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"1.74\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"CEA\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"0--5\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"μg/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XK\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"细胞角蛋白19片段\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"1.24\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"Cyfra21-1\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"0--3.3\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"μg/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XK\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"游离前列腺特异性抗原\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"0.330\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"F-PSA\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"0--0.8\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"μg/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XK\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"游离PSA/总PSA\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"0.34\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"f-PSA/TPSA\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"0.25--1\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XK\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"神经元特异烯醇化酶\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"7.64\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"NSE\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"0--15.2\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"μg/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XK\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"胃蛋白酶原Ⅰ\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"55.1\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"PGⅠ\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \">70\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"ng/ml\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XK\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"胃蛋白酶原Ⅰ/Ⅱ\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"6.8\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"PGⅠ/PGⅡ\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \">3.0\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XK\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"胃蛋白酶原Ⅱ\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"8.1\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"PGⅡ\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"ng/ml\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XK\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"胃泌素释放肽前体\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"43.23\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"ProGRP\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"0--63\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"ng/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XK\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"鳞状细胞癌相关抗原\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"1.1\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"SCC\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"0--1.5\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"ug/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XK\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"总前列腺特异性抗原\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"0.966\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"TPSA\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"0--4\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"μg/L\"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t],\n" +
            "\t\t\t\t\"VISIT_TYPE\": \"0\"\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"SPECIMEN_NAME\": \"血清(粉)\",\n" +
            "\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XM\",\n" +
            "\t\t\t\t\"VISIT_SN\": \"vis_4785faa009a6b4af3514a84cee607ad0\",\n" +
            "\t\t\t\t\"APPLY_SN\": \"19601000004XM\",\n" +
            "\t\t\t\t\"SUBMITTING_DEPARTMENT\": \"简易门诊\",\n" +
            "\t\t\t\t\"INSPECTION_NAME\": \"门特专用肝肾功能(门特);血糖(门普);血脂检测\",\n" +
            "\t\t\t\t\"PATIENT_SN\": \"pat_b72e8c3d9abcec9e5e8ecaf2c2ab0458\",\n" +
            "\t\t\t\t\"ORDER_TIME\": \"2017-03-03 15:13:00\",\n" +
            "\t\t\t\t\"sub_inspection\": [{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XM\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"白球比\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"1.51\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"A/G\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"1.2--2.4\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XM\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"★白蛋白\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"44.4\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"ALB\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"40--55\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"g/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XM\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"碱性磷酸酶\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"75\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"ALP\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"45--125\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"U/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XM\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"★丙氨酸氨基转移酶\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"13\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"ALT\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"9--50\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"U/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XM\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"载脂蛋白AI\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"1.20\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"APOA1\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"1.22--1.61\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"g/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XM\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"载脂蛋白AII\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"0.28\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"APOA2\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"0.25--0.34\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"g/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XM\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"载脂蛋白B\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"1.08\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"APOB\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"0.69--1.05\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"g/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XM\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"载脂蛋白E\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"0.04\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"APOE\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"0.03--0.05\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"g/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XM\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"★天门冬氨酸氨基转移酶\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"17\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"AST\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"15--40\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"U/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XM\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"AST/ALT比值\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"1.31\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"AST/ALT\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XM\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"★总胆固醇\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"5.88\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"CH\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"0--5.17\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"mmol/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XM\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"★肌酐\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"75\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"CREA\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"70--115\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"umol/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XM\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"直接胆红素\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"3.9\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"DBIL\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"0--3.4\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"umol/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XM\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"果糖胺\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"1.71\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"FMN\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"1.4--2.95\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"mmol/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XM\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"★γ -谷氨酰基转移酶\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"18\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"GGT\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"10--60\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"U/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XM\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"球蛋白\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"29.5\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"GLO\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"20--40\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"g/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XM\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"高密度脂蛋白胆固醇\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"1.22\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"HDL\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"0.91--2.0\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"mmol/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XM\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"★葡萄糖\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"5.53\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"HK\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"4.1--5.9\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"mmol/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XM\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"低密度脂蛋白胆固醇\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"3.82\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"LDL\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"0--3.1\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"mmol/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XM\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"脂蛋白(a)\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"699\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"LPa\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"0--300\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"mg/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XM\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"总胆红素\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"21.9\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"TBIL\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"5--21\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"umol/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XM\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"★甘油三酯\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"1.10\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"TG\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"0.7--1.7\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"mmol/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XM\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"★总蛋白\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"73.9\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"TP\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"65--85\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"g/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XM\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"★尿酸\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"304\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"UA\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"208.3--428.4\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"umol/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XM\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"★尿素\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"4.8\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"UREA\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"2.8--7.2\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"mmol/L\"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t],\n" +
            "\t\t\t\t\"VISIT_TYPE\": \"0\"\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"SPECIMEN_NAME\": \"EDTA抗凝血(紫)\",\n" +
            "\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XL\",\n" +
            "\t\t\t\t\"VISIT_SN\": \"vis_4785faa009a6b4af3514a84cee607ad0\",\n" +
            "\t\t\t\t\"APPLY_SN\": \"19601000004XL\",\n" +
            "\t\t\t\t\"SUBMITTING_DEPARTMENT\": \"简易门诊\",\n" +
            "\t\t\t\t\"INSPECTION_NAME\": \"血常规(静脉)(门特只限“白血病、淋巴瘤、骨髓瘤”)\",\n" +
            "\t\t\t\t\"PATIENT_SN\": \"pat_b72e8c3d9abcec9e5e8ecaf2c2ab0458\",\n" +
            "\t\t\t\t\"ORDER_TIME\": \"2017-03-03 15:12:00\",\n" +
            "\t\t\t\t\"sub_inspection\": [{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XL\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"嗜碱性粒细胞绝对值\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"0.05\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"BASO\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"0--0.06\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"10^9/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XL\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"嗜碱性粒细胞百分比\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"0.80\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"BASO-R\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"0--1\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"%\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XL\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"嗜酸性粒细胞绝对值\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"0.11\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"EO\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"0.02--0.52\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"10^9/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XL\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"嗜酸性粒细胞百分比\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"1.70\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"EO-R\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"0.4--8.0\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"%\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XL\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"★红细胞容积\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"49.0\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"HCT\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"40--50\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"%\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XL\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"★血红蛋白\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"161\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"HGB\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"135--175\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"g/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XL\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"未成熟粒细胞绝对值\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"0.01\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"IG\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"10^9/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XL\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"未成熟粒细胞百分比\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"0.2\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"IG-R\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"%\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XL\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"淋巴细胞绝对值\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"2.16\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"LYMPH\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"1.1--3.2\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"10^9/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XL\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"淋巴细胞百分比\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"33.80\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"LYMPH-R\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"20--50\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"%\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XL\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"平均红细胞血红蛋白含量\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"30.7\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"MCH\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"27--34\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"pg\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XL\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"平均红细胞血红蛋白浓度\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"329\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"MCHC\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"316--354\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"g/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XL\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"平均红细胞体积\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"93.3\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"MCV\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"82--100\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"fL\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XL\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"单核细胞绝对值\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"0.39\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"MONO\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"0.1--0.6\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"10^9/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XL\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"单核细胞百分比\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"6.10\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"MONO-R\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"3--10\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"%\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XL\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"平均血小板体积\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"10.2\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"MPV\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"9--13\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"fL\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XL\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"中性粒细胞绝对值\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"3.69\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"NEUT\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"1.8--6.3\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"10^9/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XL\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"中性粒细胞百分比\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"57.60\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"NEUT-R\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"40--75\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"%\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XL\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"有核红细胞绝对值\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"0.01\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"NRBC\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"10^9/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XL\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"有核红细胞百分比\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"0.2\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"NRBC-R\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"个/100WBC\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XL\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"大血小板比率\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"26.6\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"P-LCR\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"13--43\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"%\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XL\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"血小板容积\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"0.22\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"PCT\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"%\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XL\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"血小板体积分布宽度\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"11.8\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"PDW\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"9--17\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"fL\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XL\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"★血小板计数\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"220\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"PLT\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"125--350\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"10^9/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XL\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"★红细胞计数\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"5.25\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"RBC\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"4.3--5.8\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"10^12/L\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XL\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"红细胞体积分布宽度(CV)\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"11.9\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"RDW-CV\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"%\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XL\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"红细胞体积分布宽度(SD)\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"40.8\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"RDW-SD\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"37--50\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"fL\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"INSPECTION_SN\": \"4245173315453979819601000004XL\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_CN\": \"★白细胞计数\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_RESULT\": \"6.40\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_EN\": \"WBC\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_REFERENCE_INTERVAL\": \"3.5--9.5\",\n" +
            "\t\t\t\t\t\t\"SUB_INSPECTION_UNIT\": \"10^9/L\"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t],\n" +
            "\t\t\t\t\"VISIT_TYPE\": \"0\"\n" +
            "\t\t\t}\n" +
            "\t\t]\n" +
            "\t}]\n" +
            "}";
    private String condition1 = "[\n" +
            "{\n" +
            "\t\"collection\": [{\n" +
            "\t\t\"dataType\": \"string\",\n" +
            "\t\t\"dateFormat\": \"\",\n" +
            "\t\t\"uiItem\": \"visits.inspection_reports.sub_inspection.SUB_INSPECTION_CN\",\n" +
            "\t\t\"srchRelation\": \"包含\",\n" +
            "\t\t\"srchRelationValue\": \"甲胎蛋\",\n" +
            "\t\t\"relatedItems\": [{\"dataType\": \"double\",\n" +
            "\t\t\"dateFormat\": \"\",\n" +
            "\t\t\"uiItem\": \"visits.inspection_reports.sub_inspection.SUB_INSPECTION_RESULT\",\n" +
            "\t\t\"srchRelation\": \"<\",\n" +
            "\t\t\"srchRelationValue\": \"6\"},\n" +
            "\t\t{\"dataType\": \"string\",\n" +
            "\t\t\"dateFormat\": \"\",\n" +
            "\t\t\"uiItem\": \"visits.inspection_reports.sub_inspection.SUB_INSPECTION_EN\",\n" +
            "\t\t\"srchRelation\": \"包含\",\n" +
            "\t\t\"srchRelationValue\": \"AF\"}]\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"dataType\": \"string\",\n" +
            "\t\t\"dateFormat\": \"\",\n" +
            "\t\t\"uiItem\": \"visits.inspection_reports.sub_inspection.SUB_INSPECTION_CN\",\n" +
            "\t\t\"srchRelation\": \"包含\",\n" +
            "\t\t\"srchRelationValue\": \"甲胎蛋\",\n" +
            "\t\t\"relatedItems\": [{\"dataType\": \"double\",\n" +
            "\t\t\"dateFormat\": \"\",\n" +
            "\t\t\"uiItem\": \"visits.inspection_reports.sub_inspection.SUB_INSPECTION_RESULT\",\n" +
            "\t\t\"srchRelation\": \"<\",\n" +
            "\t\t\"srchRelationValue\": \"6\"},\n" +
            "\t\t{\"dataType\": \"string\",\n" +
            "\t\t\"dateFormat\": \"\",\n" +
            "\t\t\"uiItem\": \"visits.inspection_reports.sub_inspection.SUB_INSPECTION_EN\",\n" +
            "\t\t\"srchRelation\": \"包含\",\n" +
            "\t\t\"srchRelationValue\": \"AF\"}]\n" +
            "\t}]\n" +
            "}\n" +
            "\n" +
            "]";
    String condition2 = "[\n" +
            "{\n" +
            "\t\"collection\": [{\n" +
            "\t\t\"dataType\": \"string\",\n" +
            "\t\t\"dateFormat\": \"\",\n" +
            "\t\t\"uiItem\": \"visits.inspection_reports.sub_inspection.SUB_INSPECTION_CN\",\n" +
            "\t\t\"srchRelation\": \"包含\",\n" +
            "\t\t\"srchRelationValue\": \"甲胎蛋\",\n" +
            "\t\t\"relatedItems\": [{\"dataType\": \"double\",\n" +
            "\t\t\"dateFormat\": \"\",\n" +
            "\t\t\"uiItem\": \"visits.inspection_reports.sub_inspection.SUB_INSPECTION_RESULT\",\n" +
            "\t\t\"srchRelation\": \"<\",\n" +
            "\t\t\"srchRelationValue\": \"6\"},\n" +
            "\t\t{\"dataType\": \"string\",\n" +
            "\t\t\"dateFormat\": \"\",\n" +
            "\t\t\"uiItem\": \"visits.inspection_reports.sub_inspection.SUB_INSPECTION_EN\",\n" +
            "\t\t\"srchRelation\": \"包含\",\n" +
            "\t\t\"srchRelationValue\": \"AF\"}]\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"dataType\": \"string\",\n" +
            "\t\t\"dateFormat\": \"\",\n" +
            "\t\t\"uiItem\": \"visits.inspection_reports.sub_inspection.SUB_INSPECTION_CN\",\n" +
            "\t\t\"srchRelation\": \"包含\",\n" +
            "\t\t\"srchRelationValue\": \"甲胎蛋\",\n" +
            "\t\t\"relatedItems\": [{\"dataType\": \"double\",\n" +
            "\t\t\"dateFormat\": \"\",\n" +
            "\t\t\"uiItem\": \"visits.inspection_reports.sub_inspection.SUB_INSPECTION_RESULT\",\n" +
            "\t\t\"srchRelation\": \"<\",\n" +
            "\t\t\"srchRelationValue\": \"6\"},\n" +
            "\t\t{\"dataType\": \"string\",\n" +
            "\t\t\"dateFormat\": \"\",\n" +
            "\t\t\"uiItem\": \"visits.inspection_reports.sub_inspection.SUB_INSPECTION_EN\",\n" +
            "\t\t\"srchRelation\": \"包含\",\n" +
            "\t\t\"srchRelationValue\": \"AF\"}]\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"dataType\": \"string\",\n" +
            "\t\t\"dateFormat\": \"\",\n" +
            "\t\t\"uiItem\": \"visits.inspection_reports.SUBMITTING_DEPARTMENT\",\n" +
            "\t\t\"srchRelation\": \"包含\",\n" +
            "\t\t\"srchRelationValue\": \"简易\",\n" +
            "\t\t\"relatedItems\": []\n" +
            "\t}]\n" +
            "}\n" +
            "\n" +
            "]";
    String condition3 = "[{\n" +
            "\t\t\"collection\": [{\n" +
            "\t\t\t\t\"dataType\": \"string\",\n" +
            "\t\t\t\t\"dateFormat\": \"\",\n" +
            "\t\t\t\t\"uiItem\": \"visits.inspection_reports.sub_inspection.SUB_INSPECTION_CN\",\n" +
            "\t\t\t\t\"srchRelation\": \"包含\",\n" +
            "\t\t\t\t\"srchRelationValue\": \"甲胎蛋\",\n" +
            "\t\t\t\t\"relatedItems\": [{\n" +
            "\t\t\t\t\t\t\"dataType\": \"double\",\n" +
            "\t\t\t\t\t\t\"dateFormat\": \"\",\n" +
            "\t\t\t\t\t\t\"uiItem\": \"visits.inspection_reports.sub_inspection.SUB_INSPECTION_RESULT\",\n" +
            "\t\t\t\t\t\t\"srchRelation\": \"<\",\n" +
            "\t\t\t\t\t\t\"srchRelationValue\": \"6\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"dataType\": \"string\",\n" +
            "\t\t\t\t\t\t\"dateFormat\": \"\",\n" +
            "\t\t\t\t\t\t\"uiItem\": \"visits.inspection_reports.sub_inspection.SUB_INSPECTION_EN\",\n" +
            "\t\t\t\t\t\t\"srchRelation\": \"包含\",\n" +
            "\t\t\t\t\t\t\"srchRelationValue\": \"AF\"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t]\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"dataType\": \"string\",\n" +
            "\t\t\t\t\"dateFormat\": \"\",\n" +
            "\t\t\t\t\"uiItem\": \"visits.inspection_reports.sub_inspection.SUB_INSPECTION_CN\",\n" +
            "\t\t\t\t\"srchRelation\": \"包含\",\n" +
            "\t\t\t\t\"srchRelationValue\": \"甲胎蛋\",\n" +
            "\t\t\t\t\"relatedItems\": [{\n" +
            "\t\t\t\t\t\t\"dataType\": \"double\",\n" +
            "\t\t\t\t\t\t\"dateFormat\": \"\",\n" +
            "\t\t\t\t\t\t\"uiItem\": \"visits.inspection_reports.sub_inspection.SUB_INSPECTION_RESULT\",\n" +
            "\t\t\t\t\t\t\"srchRelation\": \"<\",\n" +
            "\t\t\t\t\t\t\"srchRelationValue\": \"6\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"dataType\": \"string\",\n" +
            "\t\t\t\t\t\t\"dateFormat\": \"\",\n" +
            "\t\t\t\t\t\t\"uiItem\": \"visits.inspection_reports.sub_inspection.SUB_INSPECTION_EN\",\n" +
            "\t\t\t\t\t\t\"srchRelation\": \"包含\",\n" +
            "\t\t\t\t\t\t\"srchRelationValue\": \"AF\"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t]\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"dataType\": \"string\",\n" +
            "\t\t\t\t\"dateFormat\": \"\",\n" +
            "\t\t\t\t\"uiItem\": \"visits.inspection_reports.SUBMITTING_DEPARTMENT\",\n" +
            "\t\t\t\t\"srchRelation\": \"包含\",\n" +
            "\t\t\t\t\"srchRelationValue\": \"简易111\",\n" +
            "\t\t\t\t\"relatedItems\": []\n" +
            "\t\t\t}\n" +
            "\t\t]\n" +
            "\t}\n" +
            "\n" +
            "]";
    NumberUtils numberUtils = new NumberUtils();
    private static String groups = "visits.operation_records.sub_operation_records.OPERATION_DATE";
    @org.junit.Test
    public void testFirst(){
        System.out.println(StringUtils.substringAfter(groups,"."));
        System.out.println(splitService.getFirstGroup(groups,"."));
        System.out.println(splitService.getSecondGroup(groups,".","."));
        System.out.println(splitService.getEndGroup(groups,"."));
        System.out.println(splitService.getEndGroup(StringUtils.substringBeforeLast(groups,"."),"."));
        System.out.println(StringUtils.countMatches(groups,"\\"));
        System.out.println(splitService.getBeforeLastSpliteGroup(groups,"."));
    }
    String condition4 = "[{\n" +
            "\t\t\"collection\": [{\n" +
            "\t\t\t\t\"dataType\": \"string\",\n" +
            "\t\t\t\t\"dateFormat\": \"\",\n" +
            "\t\t\t\t\"uiItem\": \"visits.inspection_reports.sub_inspection.SUB_INSPECTION_CN\",\n" +
            "\t\t\t\t\"srchRelation\": \"包含\",\n" +
            "\t\t\t\t\"srchRelationValue\": \"甲胎蛋\",\n" +
            "\t\t\t\t\"relatedItems\": [{\n" +
            "\t\t\t\t\t\t\"dataType\": \"double\",\n" +
            "\t\t\t\t\t\t\"dateFormat\": \"\",\n" +
            "\t\t\t\t\t\t\"uiItem\": \"visits.inspection_reports.sub_inspection.SUB_INSPECTION_RESULT\",\n" +
            "\t\t\t\t\t\t\"srchRelation\": \"<\",\n" +
            "\t\t\t\t\t\t\"srchRelationValue\": \"6\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"dataType\": \"string\",\n" +
            "\t\t\t\t\t\t\"dateFormat\": \"\",\n" +
            "\t\t\t\t\t\t\"uiItem\": \"visits.inspection_reports.sub_inspection.SUB_INSPECTION_EN\",\n" +
            "\t\t\t\t\t\t\"srchRelation\": \"包含\",\n" +
            "\t\t\t\t\t\t\"srchRelationValue\": \"A\"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t]\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"dataType\": \"string\",\n" +
            "\t\t\t\t\"dateFormat\": \"\",\n" +
            "\t\t\t\t\"uiItem\": \"visits.inspection_reports.sub_inspection.SUB_INSPECTION_CN\",\n" +
            "\t\t\t\t\"srchRelation\": \"包含\",\n" +
            "\t\t\t\t\"srchRelationValue\": \"甲胎蛋\",\n" +
            "\t\t\t\t\"relatedItems\": [{\n" +
            "\t\t\t\t\t\t\"dataType\": \"double\",\n" +
            "\t\t\t\t\t\t\"dateFormat\": \"\",\n" +
            "\t\t\t\t\t\t\"uiItem\": \"visits.inspection_reports.sub_inspection.SUB_INSPECTION_RESULT\",\n" +
            "\t\t\t\t\t\t\"srchRelation\": \"<\",\n" +
            "\t\t\t\t\t\t\"srchRelationValue\": \"6\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"dataType\": \"string\",\n" +
            "\t\t\t\t\t\t\"dateFormat\": \"\",\n" +
            "\t\t\t\t\t\t\"uiItem\": \"visits.inspection_reports.sub_inspection.SUB_INSPECTION_EN\",\n" +
            "\t\t\t\t\t\t\"srchRelation\": \"包含\",\n" +
            "\t\t\t\t\t\t\"srchRelationValue\": \"AF\"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t]\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"dataType\": \"string\",\n" +
            "\t\t\t\t\"dateFormat\": \"\",\n" +
            "\t\t\t\t\"uiItem\": \"visits.inspection_reports.SUBMITTING_DEPARTMENT\",\n" +
            "\t\t\t\t\"srchRelation\": \"包含\",\n" +
            "\t\t\t\t\"srchRelationValue\": \"简易\",\n" +
            "\t\t\t\t\"relatedItems\": []\n" +
            "\t\t\t}\n" +
            "\t\t]\n" +
            "\t}\n" +
            "\n" +
            "]";
    @org.junit.Test
    public void testNumberUtisl(){
        System.out.println(numberUtils.equals("2.0","2.000000"));
    }
    @org.junit.Test
    public void testFilter(){
        ConcurrentHashMap<String, String> releas = new ConcurrentHashMap<String, String>();
        JSONObject patient = JSONObject.parseObject(patients);
        JSONArray visits = patient.getJSONArray("visits");
        JSONObject jsonObject = visits.getJSONObject(0);
        MathCalculate calculate = new MathCalculate(jsonObject);
        JSONArray array = JSONArray.parseArray(condition4);
        calculate.calc(array,releas);
    }
}
