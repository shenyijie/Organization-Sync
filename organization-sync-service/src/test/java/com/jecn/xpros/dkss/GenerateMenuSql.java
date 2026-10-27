package com.shine.company;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * ━━━━━━━━━佛祖保佑━━━━━━━━━━━
 *                  ,;,,;
 *                ,;;' (    社
 *      ___      ,;;' ' \   会
 *    /'  '\'~~'~' \ /'\.)  主
 * ,;(      )     /  |.     义
 *,;' \    /-.,,(   ) \     码
 *     ) /       ) / )|     农
 *     ||        ||  \\
 *    (_\       (_\  (_\
 * ━━━━━━━━━永无BUG━━━━━━━━━━━━
 *
 * @author Shine
 * @since 2025/9/28 15:15
 */
public class GenerateMenuSql {
    private final Map<String, String> keyMap = MapUtil.newHashMap();
    private final Map<String, String> keyNameMap = MapUtil.newHashMap();
    private final List<String> keyList = CollectionUtil.newArrayList();

    private final Map<String, Long> keyIdMap = MapUtil.newHashMap();
    private final Map<String, String> pathMap = MapUtil.newHashMap();

    public GenerateMenuSql() {
        JSONArray ssKeys = JSONUtil.parseArray("[\"XPROS_DC\", \"XPROS_DC_PROJECT\", \"XPROS_DC_PROJECT_SAVE\", \"XPROS_DC_PROJECT_DEL\", \"XPROS_DC_PROJECT_DETAIL\", \"XPROS_DC_PROJECT_RENAME\", \"XPROS_DC_PROJECT_COPY\", \"XPROS_DC_PROJECT_MOVE\", \"XPROS_DC_CONNECT\", \"XPROS_DC_CONNECT_SAVE\", \"XPROS_DC_CONNECT_DEL\", \"XPROS_DC_CONNECT_DETAIL\", \"XPROS_DC_CONNECT_RENAME\", \"XPROS_DC_CONNECT_COPY\", \"XPROS_DC_CONNECT_MOVE\", \"XPROS_DC_CONNECT_CHECK\", \"XPROS_DC_EXTRACT\", \"XPROS_DC_EXTRACT_SAVE\", \"XPROS_DC_EXTRACT_DEL\", \"XPROS_DC_EXTRACT_DETAIL\", \"XPROS_DC_EXTRACT_RENAME\", \"XPROS_DC_EXTRACT_COPY\", \"XPROS_DC_EXTRACT_MOVE\", \"XPROS_DC_EXTRACT_EXTRACTION\", \"XPROS_DC_TRANSFORM\", \"XPROS_DC_TRANSFORM_SAVE\", \"XPROS_DC_TRANSFORM_DEL\", \"XPROS_DC_TRANSFORM_DETAIL\", \"XPROS_DC_TRANSFORM_RENAME\", \"XPROS_DC_TRANSFORM_COPY\", \"XPROS_DC_TRANSFORM_MOVE\", \"XPROS_DC_TRANSFORM_EXEC\", \"XPROS_DC_TRANSFORM_SQL_EXEC\", \"XPROS_DC_MODEL\", \"XPROS_DC_MODEL_SAVE\", \"XPROS_DC_MODEL_DEL\", \"XPROS_DC_MODEL_DETAIL\", \"XPROS_DC_MODEL_RENAME\", \"XPROS_DC_MODEL_COPY\", \"XPROS_DC_MODEL_MOVE\", \"XPROS_DC_MODEL_EXEC\", \"XPROS_DC_MODEL_CHECK\", \"XPROS_DC_TASK\", \"XPROS_DC_TASK_SAVE\", \"XPROS_DC_TASK_DEL\", \"XPROS_DC_TASK_DETAIL\", \"XPROS_DC_TASK_RENAME\", \"XPROS_DC_TASK_COPY\", \"XPROS_DC_TASK_MOVE\", \"XPROS_DC_TASK_EXEC\", \"XPROS_DC_SHEET\", \"XPROS_DC_SHEET_DEL\", \"XPROS_DC_SHEET_RENAME\", \"XPROS_DC_SHEET_MOVE\", \"XPROS_DC_SHEET_PREVIEW\", \"XPROS_DC_SHEET_EXPORT\", \"XPROS_PMA\", \"XPROS_PMA_DIR\", \"XPROS_PMA_DIR_LIST\", \"XPROS_PMA_DIR_ADD\", \"XPROS_PMA_DIR_EDIT\", \"XPROS_PMA_DIR_EDIT_PERMISSION\", \"XPROS_PMA_DIR_DEL\", \"XPROS_PMA_PROJECT\", \"XPROS_PMA_PROJECT_LIST\", \"XPROS_PMA_PROJECT_ADD\", \"XPROS_PMA_PROJECT_EDIT\", \"XPROS_PMA_PROJECT_EDIT_PERMISSION\", \"XPROS_PMA_PROJECT_DEL\", \"XPROS_PMA_ANALYSIS\", \"XPROS_PMA_ANALYSIS_LIST\", \"XPROS_PMA_ANALYSIS_ADD\", \"XPROS_PMA_ANALYSIS_EDIT\", \"XPROS_PMA_ANALYSIS_EDIT_PERMISSION\", \"XPROS_PMA_ANALYSIS_DEL\", \"XPROS_PMA_DOWNLOAD\", \"XPROS_PMA_DOWNLOAD_PM_IMAGE\", \"XPROS_PMA_DOWNLOAD_ACT_TAG\", \"XPROS_PMA_DOWNLOAD_CASE_DISTRIBUTION\", \"XPROS_PMA_DOWNLOAD_EVENT_DISTRIBUTION\", \"XPROS_PMA_DOWNLOAD_CASE\", \"XPROS_PMA_DOWNLOAD_EVENT\", \"XPROS_PMA_DOWNLOAD_VARIATION\", \"XPROS_PMA_DOWNLOAD_PERFORMANCE\", \"XPROS_PMA_DOWNLOAD_PERFORMANCE_TREND_CHART\", \"XPROS_PMA_DOWNLOAD_ACT_REWORK\", \"XPROS_PMA_DOWNLOAD_CASE_REWORK\", \"XPROS_PMA_DOWNLOAD_BI\", \"XPROS_MC\", \"XPROS_MC_METRICS_PANEL\", \"XPROS_ALERT_METRICS_PANEL_DETAIL\", \"XPROS_ALERT_METRICS_PANEL_ADD\", \"XPROS_ALERT_METRICS_PANEL_EDIT\", \"XPROS_ALERT_METRICS_PANEL_EDIT_PERMISSION\", \"XPROS_ALERT_METRICS_PANEL_DEL\", \"XPROS_ALERT_PANEL\", \"XPROS_ALERT_PANEL_STATISTICS\", \"XPROS_ALERT_PANEL_LATEST\", \"XPROS_ALERT_PANEL_RANK\", \"XPROS_ALERT_ALARM\", \"XPROS_ALERT_ALARM_LIST\", \"XPROS_ALERT_ALARM_CASE_LIST\", \"XPROS_ALERT_ALARM_DEL\", \"XPROS_ALERT_ALARM_DOWNLOAD\", \"XPROS_ALERT_ALARM_EVENT_LIST\", \"XPROS_ALERT_RULES\", \"XPROS_ALERT_RULES_LIST\", \"XPROS_ALERT_RULES_ADD\", \"XPROS_ALERT_RULES_EDIT\", \"XPROS_ALERT_RULES_DEL\", \"XPROS_TEMPLATE\", \"XPROS_TEMPLATE_PMA\", \"XPROS_TEMPLATE_PMA_ORIGINAL\", \"XPROS_TEMPLATE_PMA_PUBLISH\", \"XPROS_TEMPLATE_DC\", \"XPROS_TEMPLATE_DC_EXT\", \"XPROS_TEMPLATE_DC_EXT_ORIGINAL_LIST\", \"XPROS_TEMPLATE_DC_EXT_PAGE_APPROVAL\", \"XPROS_TEMPLATE_DC_TSF\", \"XPROS_TEMPLATE_DC_TSF_ORIGINAL_LIST\", \"XPROS_TEMPLATE_DC_TSF_PAGE_APPROVAL\", \"XPROS_TEMPLATE_DC_MOD\", \"XPROS_TEMPLATE_DC_MOD_LIST_ORIGINAL_TEMPLATE\", \"XPROS_TEMPLATE_DC_MOD_PAGE_APPROVAL\", \"XPROS_TEMPLATE_WTIME\", \"XPROS_TEMPLATE_WTIME_ORIGINAL\", \"XPROS_TEMPLATE_WTIME_PUBLISH\"]");

        JSONArray xprosKeys = JSONUtil.parseArray("[\"dc\", \"dc.project\", \"dc.project.save\", \"dc.project.del\", \"dc.project.detail\", \"dc.project.rename\", \"dc.project.copy\", \"dc.project.move\", \"dc.connect\", \"dc.connect.save\", \"dc.connect.del\", \"dc.connect.detail\", \"dc.connect.rename\", \"dc.connect.copy\", \"dc.connect.move\", \"dc.connect.check\", \"dc.extract\", \"dc.extract.save\", \"dc.extract.del\", \"dc.extract.detail\", \"dc.extract.rename\", \"dc.extract.copy\", \"dc.extract.move\", \"dc.extract.extraction\", \"dc.transform\", \"dc.transform.save\", \"dc.transform.del\", \"dc.transform.detail\", \"dc.transform.rename\", \"dc.transform.copy\", \"dc.transform.move\", \"dc.transform.exec\", \"dc.transform.sqlExec\", \"dc.model\", \"dc.model.save\", \"dc.model.del\", \"dc.model.detail\", \"dc.model.rename\", \"dc.model.copy\", \"dc.model.move\", \"dc.model.exec\", \"dc.model.check\", \"dc.task\", \"dc.task.save\", \"dc.task.del\", \"dc.task.detail\", \"dc.task.rename\", \"dc.task.copy\", \"dc.task.move\", \"dc.task.exec\", \"dc.sheet\", \"dc.sheet.del\", \"dc.sheet.rename\", \"dc.sheet.move\", \"dc.sheet.preview\", \"dc.sheet.export\", \"pma\", \"pma.dir\", \"pma.dir.list\", \"pma.dir.add\", \"pma.dir.edit\", \"pma.dir.editPermission\", \"pma.dir.del\", \"pma.project\", \"pma.project.list\", \"pma.project.add\", \"pma.project.edit\", \"pma.project.editPermission\", \"pma.project.del\", \"pma.analysis\", \"pma.analysis.list\", \"pma.analysis.add\", \"pma.analysis.edit\", \"pma.analysis.editPermission\", \"pma.analysis.del\", \"pma.download\", \"pma.download.pmImage\", \"pma.download.actTag\", \"pma.download.caseDistribution\", \"pma.download.eventDistribution\", \"pma.download.case\", \"pma.download.event\", \"pma.download.variation\", \"pma.download.performance\", \"pma.download.performanceTrendChart\", \"pma.download.actRework\", \"pma.download.caseRework\", \"pma.download.bi\", \"mc\", \"mc.metricsPanel\", \"alert.metricsPanel.detail\", \"alert.metricsPanel.add\", \"alert.metricsPanel.edit\", \"alert.metricsPanel.editPermission\", \"alert.metricsPanel.del\", \"alert.panel\", \"alert.panel.statistics\", \"alert.panel.latest\", \"alert.panel.rank\", \"alert.alarm\", \"alert.alarm.list\", \"alert.alarm.caseList\", \"alert.alarm.del\", \"alert.alarm.download\", \"alert.alarm.eventList\", \"alert.rules\", \"alert.rules.list\", \"alert.rules.add\", \"alert.rules.edit\", \"alert.rules.del\", \"template\", \"template.pma\", \"template.pma.original\", \"template.pma.publish\", \"template.dc\", \"template.dc.ext\", \"template.dc.ext.originalList\", \"template.dc.ext.pageApproval\", \"template.dc.tsf\", \"template.dc.tsf.originalList\", \"template.dc.tsf.pageApproval\", \"template.dc.mod\", \"template.dc.mod.listOriginalTemplate\", \"template.dc.mod.pageApproval\", \"template.wtime\", \"template.wtime.original\", \"template.wtime.publish\"]");

        JSONArray keyNames = JSONUtil.parseArray("[\"数据中心\", \"数据项目\", \"保存\", \"删除\", \"查看详情\", \"重命名\", \"复制\", \"移动\", \"数据连接\", \"保存\", \"删除\", \"查看详情\", \"重命名\", \"复制\", \"移动\", \"连接检测\", \"数据提取\", \"保存\", \"删除\", \"查看详情\", \"重命名\", \"复制\", \"移动\", \"执行提取\", \"数据转换\", \"保存\", \"删除\", \"查看详情\", \"重命名\", \"复制\", \"移动\", \"执行转换\", \"SQL执行\", \"数据建模\", \"保存\", \"删除\", \"查看详情\", \"重命名\", \"复制\", \"移动\", \"模型加载\", \"模型检测\", \"数据任务\", \"保存\", \"删除\", \"查看详情\", \"重命名\", \"复制\", \"移动\", \"执行任务\", \"数据列表\", \"删除\", \"重命名\", \"移动\", \"表单预览\", \"导出至本地\", \"流程分析\", \"文件夹管理\", \"查看文件夹\", \"新建文件夹\", \"编辑文件夹\", \"分配权限\", \"删除文件夹\", \"项目管理\", \"查看项目\", \"新建项目\", \"编辑项目\", \"分配权限\", \"删除项目\", \"分析管理\", \"查看分析\", \"新建分析\", \"编辑分析\", \"分配权限\", \"删除分析\", \"下载管理\", \"下载流程图\", \"下载活动指标\", \"下载案例周期分布\", \"下载事件周期分布\", \"下载案例\", \"下载事件日志\", \"下载变种\", \"下载绩效偏差分析\", \"下载绩效偏差案例合格趋势图\", \"下载活动返工情况\", \"下载案例返工情况\", \"下载自定义BI图表数据\", \"监控中心\", \"指标监控概况\", \"查看面板\", \"新增面板\", \"编辑面板\", \"分配权限\", \"删除面板\", \"监控概况\", \"告警总览\", \"最新告警信息\", \"告警排行榜\", \"告警信息\", \"查看告警信息\", \"查看案例\", \"删除告警信息\", \"下载案例\", \"查看事件\", \"规则管理\", \"查看规则\", \"新增规则\", \"编辑规则\", \"删除规则\", \"模板市场\", \"流程分析模板\", \"原创管理\", \"发布管理\", \"数据中心模板\", \"数据提取模板\", \"原创管理\", \"发布管理\", \"数据转换模板\", \"原创管理\", \"发布管理\", \"数据建模模板\", \"原创管理\", \"发布管理\", \"工作时间模板\", \"原创管理\", \"发布管理\"]");

        for (int i = 0; i < ssKeys.size(); i++) {
            String ssKey = ssKeys.getStr(i);
            keyMap.put(ssKey, xprosKeys.getStr(i));
            keyNameMap.put(ssKey, keyNames.getStr(i));
            keyList.add(ssKey);
        }
    }

    public void generate() {
        String insertSql = "insert into sys_menu(MENU_ID_, APP_ID_, NAME_, PARENT_ID_, PATH_, SN_, SHOW_TYPE_, MENU_KEY_, MENU_TYPE_, SETTING_TYPE_,PARAMS_, DELETED_, COMPANY_ID_, TENANT_ID_, CREATE_DEP_ID_, CREATE_BY_, CREATE_TIME_, UPDATE_BY_,UPDATE_TIME_, SYS_TYPE_, iS_EXPORT_, URL_, METHOD_, TYPE_) values ('{}', '{}', '{}', '{}', '{}', '{}', {}, '{}', '{}', '{}', '{}', '{}', '{}', '{}', '{}', '{}', '{}', '{}', '{}', '{}', '{}', {}, {}, {} );";

        for (String ssKey : keyList) {
            String xprosKey = keyMap.get(ssKey);
            String parentKey = getParentKey(xprosKey);
            Long key = IdUtil.getSnowflakeNextId();
            keyIdMap.put(xprosKey, key);
            if (Objects.isNull(parentKey)) {
                String path = StrUtil.format("0.{}.", key);
                pathMap.put(xprosKey, path);
                String sql = StrUtil.format(
                        insertSql,
                        key,
                        "65b1da7e-db44-49ba-8174-0e7b00b2f69c",
                        keyNameMap.get(ssKey),
                        "0",
                        path,
                        "0",
                        "'URL'", // SHOW_TYPE_：有地址的为url，没地址为null
                        ssKey,
                        "F", // MENU_TYPE_：菜单C 按钮F
                        "iframe", // SETTING_TYPE_
                        "xxx", // PARAMS_
                        "0",
                        "0",
                        "1",
                        "1", // CREATE_DEP_ID_
                        "1", // CREATE_BY_
                        "2025-09-28 00:00:00",
                        "1",
                        "2025-09-28 00:00:00",
                        "0",
                        "1",
                        "null", // URL_
                        "null", // METHOD_
                        "null"  // TYPE_
                );
                System.out.println(sql);
            } else {
                String path = StrUtil.format("{}{}.", pathMap.get(parentKey), key);
                pathMap.put(xprosKey, path);
                String sql = StrUtil.format(
                        insertSql,
                        key,
                        "65b1da7e-db44-49ba-8174-0e7b00b2f69c",
                        keyNameMap.get(ssKey),
                        "0",
                        path,
                        "0",
                        "null", // SHOW_TYPE_ 待确认
                        ssKey,
                        "C", // MENU_TYPE_：菜单C 按钮F
                        "iframe", // SETTING_TYPE_
                        "xxx", // PARAMS_
                        "0",
                        "0",
                        "1",
                        "1", // CREATE_DEP_ID_
                        "1", // CREATE_BY_
                        "2025-09-28 00:00:00",
                        "1",
                        "2025-09-28 00:00:00",
                        "0",
                        "1",
                        "null",
                        "null",
                        "null"
                );
                System.out.println(sql);
            }
        }
    }

    private String getParentKey(String xprosKey) {
        if (!StrUtil.contains(xprosKey, ".")) {
            return null;
        }
        return xprosKey.substring(0, xprosKey.lastIndexOf("."));
    }
}
