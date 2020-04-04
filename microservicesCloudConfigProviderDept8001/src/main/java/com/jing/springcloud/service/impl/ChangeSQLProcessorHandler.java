package com.jing.springcloud.service.impl;

/**
 * @program: IntegratedBis_Junan365
 * @Date: 2019/9/4 10:03
 * @Author: Jing
 * @Description:
 */
//@Component
//public class ChangeSQLProcessorHandler extends ABSBaseCustomProcessorHandler {
//
//    private final Logger logger = Logger.getLogger(ChangeSQLProcessorHandler.class);
//
//    @Override
//    public void resetResultMsg() {
//        setSuccessMsg("SQL转换成功");
//        setFailMsg("SQL转换失败");
//    }
//
//    @Override
//    public Object handleDataResult(Map<String, Object> result) throws Exception {
//        String path = "E:\\ali\\work\\workspace\\Junan\\CDCheck\\src\\main\\resources\\dbupdate\\1.0.2\\1.0.2.4_alpha.sql";
//        File file = new File(path);
//        FileInputStream fis = new FileInputStream(file);
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(fis, StandardCharsets.UTF_8));
//        String line;
//        StringBuilder builder = new StringBuilder();
//        while ((line = reader.readLine()) != null) {
//            if (!StringUtils.isEmpty(line) && !line.contains("FROM DUAL WHERE NOT EXISTS(SELECT")) {
//                builder.append(handleSQLChange(line)).append("\n");
//            }
//        }
//        logger.info("新拼接的SQL内容 : " + builder.toString());
//        //最后记得，关闭流
//        fis.close();
//        return null;
//    }
//
//    private String handleSQLChange(String line) {
//        StringBuilder builder = new StringBuilder();
//        String str = "INSERT INTO `tb_plf_oauth2_third_system_if`(`id`, `name`, `desc`, `if_address`, `req_type`, `if_id`, " +
//                "`if_secret`, `type`, `enable_status`, `isproxy`, `tsystem`) " +
//                "VALUES " +
//                "(1, '应用接入公告服务接口', '用于应用接入平台时，接收平台发送的接入公告消息的服务接口', '/3rdapp/notice/connect', 'POST', " +
//                "'1000001', 'cfd860a868fc800f4eb9252f4c6a2362', 1, 1, 0, 1); ";
//        String[] sql = line.split("VALUES");
//        builder.append(sql[0]);
//
//        String tableName = "";
//        String[] pms = sql[0].split("`");
//        for (String pm : pms) {
//            if (pm.contains("tb_")) {
//                tableName = pm;
//            }
//        }
//
//        String[] values = sql[1].split(",");
//        builder.append("SELECT ");
//        long id = -1;
//        for (int i = 0; i < values.length; i++) {
//            String val = values[i];
//            if (i == 0) {
//                int idIdx = val.indexOf("(");
//                id = Long.parseLong(val.substring(idIdx + 1));
//                builder.append(val, idIdx + 1, val.length()).append(",").append(" ");
//            } else if (i == values.length - 1) {
//                builder.append(val, 0, val.indexOf(")")).append(" ");
//            } else {
//                builder.append(val).append(",").append(" ");
//            }
//        }
//        if (id == -1) return "";
//        return builder.append(" FROM DUAL WHERE NOT EXISTS(SELECT * FROM `").append(tableName).append("` WHERE `id` = ").append(id).append(");").toString();
//    }
//
//}
