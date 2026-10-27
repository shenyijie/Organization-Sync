package com.shine.company;

import cn.hutool.core.map.MapUtil;

import java.util.Map;

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
 * @since 2025/7/21 11:31
 */
public class Constant {
    public final static Long COMPANY_ID = 166666688888888888L;
    public final static Long DEFAULT_ROLE_ID = 100000000000000001L;
    public final static Long ROOT_ID = -1L;
    public final static String RESIGN = "离职";

    public final static Map<String, String> PERMISSON_KEY_MAP = MapUtil.newHashMap();
    static {
        PERMISSON_KEY_MAP.put("XPROS_DC", "dc");
        PERMISSON_KEY_MAP.put("XPROS_DC_PROJECT", "dc.project");
        PERMISSON_KEY_MAP.put("XPROS_DC_PROJECT_SAVE", "dc.project.save");
        PERMISSON_KEY_MAP.put("XPROS_DC_PROJECT_DEL", "dc.project.del");
        PERMISSON_KEY_MAP.put("XPROS_DC_PROJECT_DETAIL", "dc.project.detail");
        PERMISSON_KEY_MAP.put("XPROS_DC_PROJECT_RENAME", "dc.project.rename");
        PERMISSON_KEY_MAP.put("XPROS_DC_PROJECT_COPY", "dc.project.copy");
        PERMISSON_KEY_MAP.put("XPROS_DC_PROJECT_MOVE", "dc.project.move");
        PERMISSON_KEY_MAP.put("XPROS_DC_CONNECT", "dc.connect");
        PERMISSON_KEY_MAP.put("XPROS_DC_CONNECT_SAVE", "dc.connect.save");
        PERMISSON_KEY_MAP.put("XPROS_DC_CONNECT_DEL", "dc.connect.del");
        PERMISSON_KEY_MAP.put("XPROS_DC_CONNECT_DETAIL", "dc.connect.detail");
        PERMISSON_KEY_MAP.put("XPROS_DC_CONNECT_RENAME", "dc.connect.rename");
        PERMISSON_KEY_MAP.put("XPROS_DC_CONNECT_COPY", "dc.connect.copy");
        PERMISSON_KEY_MAP.put("XPROS_DC_CONNECT_MOVE", "dc.connect.move");
        PERMISSON_KEY_MAP.put("XPROS_DC_CONNECT_CHECK", "dc.connect.check");
        PERMISSON_KEY_MAP.put("XPROS_DC_EXTRACT", "dc.extract");
        PERMISSON_KEY_MAP.put("XPROS_DC_EXTRACT_SAVE", "dc.extract.save");
        PERMISSON_KEY_MAP.put("XPROS_DC_EXTRACT_DEL", "dc.extract.del");
        PERMISSON_KEY_MAP.put("XPROS_DC_EXTRACT_DETAIL", "dc.extract.detail");
        PERMISSON_KEY_MAP.put("XPROS_DC_EXTRACT_RENAME", "dc.extract.rename");
        PERMISSON_KEY_MAP.put("XPROS_DC_EXTRACT_COPY", "dc.extract.copy");
        PERMISSON_KEY_MAP.put("XPROS_DC_EXTRACT_MOVE", "dc.extract.move");
        PERMISSON_KEY_MAP.put("XPROS_DC_EXTRACT_EXTRACTION", "dc.extract.extraction");
        PERMISSON_KEY_MAP.put("XPROS_DC_TRANSFORM", "dc.transform");
        PERMISSON_KEY_MAP.put("XPROS_DC_TRANSFORM_SAVE", "dc.transform.save");
        PERMISSON_KEY_MAP.put("XPROS_DC_TRANSFORM_DEL", "dc.transform.del");
        PERMISSON_KEY_MAP.put("XPROS_DC_TRANSFORM_DETAIL", "dc.transform.detail");
        PERMISSON_KEY_MAP.put("XPROS_DC_TRANSFORM_RENAME", "dc.transform.rename");
        PERMISSON_KEY_MAP.put("XPROS_DC_TRANSFORM_COPY", "dc.transform.copy");
        PERMISSON_KEY_MAP.put("XPROS_DC_TRANSFORM_MOVE", "dc.transform.move");
        PERMISSON_KEY_MAP.put("XPROS_DC_TRANSFORM_EXEC", "dc.transform.exec");
        PERMISSON_KEY_MAP.put("XPROS_DC_TRANSFORM_SQL_EXEC", "dc.transform.sqlExec");
        PERMISSON_KEY_MAP.put("XPROS_DC_MODEL", "dc.model");
        PERMISSON_KEY_MAP.put("XPROS_DC_MODEL_SAVE", "dc.model.save");
        PERMISSON_KEY_MAP.put("XPROS_DC_MODEL_DEL", "dc.model.del");
        PERMISSON_KEY_MAP.put("XPROS_DC_MODEL_DETAIL", "dc.model.detail");
        PERMISSON_KEY_MAP.put("XPROS_DC_MODEL_RENAME", "dc.model.rename");
        PERMISSON_KEY_MAP.put("XPROS_DC_MODEL_COPY", "dc.model.copy");
        PERMISSON_KEY_MAP.put("XPROS_DC_MODEL_MOVE", "dc.model.move");
        PERMISSON_KEY_MAP.put("XPROS_DC_MODEL_EXEC", "dc.model.exec");
        PERMISSON_KEY_MAP.put("XPROS_DC_MODEL_CHECK", "dc.model.check");
        PERMISSON_KEY_MAP.put("XPROS_DC_TASK", "dc.task");
        PERMISSON_KEY_MAP.put("XPROS_DC_TASK_SAVE", "dc.task.save");
        PERMISSON_KEY_MAP.put("XPROS_DC_TASK_DEL", "dc.task.del");
        PERMISSON_KEY_MAP.put("XPROS_DC_TASK_DETAIL", "dc.task.detail");
        PERMISSON_KEY_MAP.put("XPROS_DC_TASK_RENAME", "dc.task.rename");
        PERMISSON_KEY_MAP.put("XPROS_DC_TASK_COPY", "dc.task.copy");
        PERMISSON_KEY_MAP.put("XPROS_DC_TASK_MOVE", "dc.task.move");
        PERMISSON_KEY_MAP.put("XPROS_DC_TASK_EXEC", "dc.task.exec");
        PERMISSON_KEY_MAP.put("XPROS_DC_SHEET", "dc.sheet");
        PERMISSON_KEY_MAP.put("XPROS_DC_SHEET_DEL", "dc.sheet.del");
        PERMISSON_KEY_MAP.put("XPROS_DC_SHEET_RENAME", "dc.sheet.rename");
        PERMISSON_KEY_MAP.put("XPROS_DC_SHEET_MOVE", "dc.sheet.move");
        PERMISSON_KEY_MAP.put("XPROS_DC_SHEET_PREVIEW", "dc.sheet.preview");
        PERMISSON_KEY_MAP.put("XPROS_DC_SHEET_EXPORT", "dc.sheet.export");
        PERMISSON_KEY_MAP.put("XPROS_PMA", "pma");
        PERMISSON_KEY_MAP.put("XPROS_PMA_DIR_MAIN", "pma.dir.main");
        PERMISSON_KEY_MAP.put("XPROS_PMA_DIR_MAIN_LIST", "pma.dir.main.list");
        PERMISSON_KEY_MAP.put("XPROS_PMA_DIR_MAIN_ADD", "pma.dir.main.add");
        PERMISSON_KEY_MAP.put("XPROS_PMA_DIR_MAIN_EDIT", "pma.dir.main.edit");
        PERMISSON_KEY_MAP.put("XPROS_PMA_DIR_MAIN_EDIT_PERMISSION", "pma.dir.main.editPermission");
        PERMISSON_KEY_MAP.put("XPROS_PMA_DIR_MAIN_DEL", "pma.dir.main.del");
        PERMISSON_KEY_MAP.put("XPROS_PMA_DIR_CHILD", "pma.dir.child");
        PERMISSON_KEY_MAP.put("XPROS_PMA_DIR_CHILD_LIST", "pma.dir.child.list");
        PERMISSON_KEY_MAP.put("XPROS_PMA_DIR_CHILD_ADD", "pma.dir.child.edit");
        PERMISSON_KEY_MAP.put("XPROS_PMA_DIR_CHILD_EDIT", "pma.dir.child.add");
        PERMISSON_KEY_MAP.put("XPROS_PMA_DIR_CHILD_EDIT_PERMISSION", "pma.dir.child.editPermission");
        PERMISSON_KEY_MAP.put("XPROS_PMA_DIR_CHILD_DEL", "pma.dir.child.del");
        PERMISSON_KEY_MAP.put("XPROS_PMA_PROJECT", "pma.project");
        PERMISSON_KEY_MAP.put("XPROS_PMA_PROJECT_LIST", "pma.project.list");
        PERMISSON_KEY_MAP.put("XPROS_PMA_PROJECT_ADD", "pma.project.add");
        PERMISSON_KEY_MAP.put("XPROS_PMA_PROJECT_EDIT", "pma.project.edit");
        PERMISSON_KEY_MAP.put("XPROS_PMA_PROJECT_EDIT_PERMISSION", "pma.project.editPermission");
        PERMISSON_KEY_MAP.put("XPROS_PMA_PROJECT_DEL", "pma.project.del");
        PERMISSON_KEY_MAP.put("XPROS_PMA_ANALYSIS", "pma.analysis");
        PERMISSON_KEY_MAP.put("XPROS_PMA_ANALYSIS_LIST", "pma.analysis.list");
        PERMISSON_KEY_MAP.put("XPROS_PMA_ANALYSIS_ADD", "pma.analysis.add");
        PERMISSON_KEY_MAP.put("XPROS_PMA_ANALYSIS_EDIT", "pma.analysis.edit");
        PERMISSON_KEY_MAP.put("XPROS_PMA_ANALYSIS_EDIT_PERMISSION", "pma.analysis.editPermission");
        PERMISSON_KEY_MAP.put("XPROS_PMA_ANALYSIS_DEL", "pma.analysis.del");
        PERMISSON_KEY_MAP.put("XPROS_PMA_DOWNLOAD", "pma.download");
        PERMISSON_KEY_MAP.put("XPROS_PMA_DOWNLOAD_PM_IMAGE", "pma.download.pmImage");
        PERMISSON_KEY_MAP.put("XPROS_PMA_DOWNLOAD_ACT_TAG", "pma.download.actTag");
        PERMISSON_KEY_MAP.put("XPROS_PMA_DOWNLOAD_CASE_DISTRIBUTION", "pma.download.caseDistribution");
        PERMISSON_KEY_MAP.put("XPROS_PMA_DOWNLOAD_EVENT_DISTRIBUTION", "pma.download.eventDistribution");
        PERMISSON_KEY_MAP.put("XPROS_PMA_DOWNLOAD_CASE", "pma.download.case");
        PERMISSON_KEY_MAP.put("XPROS_PMA_DOWNLOAD_EVENT", "pma.download.event");
        PERMISSON_KEY_MAP.put("XPROS_PMA_DOWNLOAD_VARIATION", "pma.download.variation");
        PERMISSON_KEY_MAP.put("XPROS_PMA_DOWNLOAD_PERFORMANCE", "pma.download.performance");
        PERMISSON_KEY_MAP.put("XPROS_PMA_DOWNLOAD_PERFORMANCE_TREND_CHART", "pma.download.performanceTrendChart");
        PERMISSON_KEY_MAP.put("XPROS_PMA_DOWNLOAD_ACT_REWORK", "pma.download.actRework");
        PERMISSON_KEY_MAP.put("XPROS_PMA_DOWNLOAD_CASE_REWORK", "pma.download.caseRework");
        PERMISSON_KEY_MAP.put("XPROS_PMA_DOWNLOAD_BI", "pma.download.bi");
        PERMISSON_KEY_MAP.put("XPROS_MC", "mc");
        PERMISSON_KEY_MAP.put("XPROS_MC_METRICS_PANEL", "mc.metricsPanel");
        PERMISSON_KEY_MAP.put("XPROS_ALERT_METRICS_PANEL_DETAIL", "alert.metricsPanel.detail");
        PERMISSON_KEY_MAP.put("XPROS_ALERT_METRICS_PANEL_ADD", "alert.metricsPanel.add");
        PERMISSON_KEY_MAP.put("XPROS_ALERT_METRICS_PANEL_EDIT", "alert.metricsPanel.edit");
        PERMISSON_KEY_MAP.put("XPROS_ALERT_METRICS_PANEL_EDIT_PERMISSION", "alert.metricsPanel.editPermission");
        PERMISSON_KEY_MAP.put("XPROS_ALERT_METRICS_PANEL_DEL", "alert.metricsPanel.del");
        PERMISSON_KEY_MAP.put("XPROS_ALERT_PANEL", "alert.panel");
        PERMISSON_KEY_MAP.put("XPROS_ALERT_PANEL_STATISTICS", "alert.panel.statistics");
        PERMISSON_KEY_MAP.put("XPROS_ALERT_PANEL_LATEST", "alert.panel.latest");
        PERMISSON_KEY_MAP.put("XPROS_ALERT_PANEL_RANK", "alert.panel.rank");
        PERMISSON_KEY_MAP.put("XPROS_ALERT_ALARM", "alert.alarm");
        PERMISSON_KEY_MAP.put("XPROS_ALERT_ALARM_LIST", "alert.alarm.list");
        PERMISSON_KEY_MAP.put("XPROS_ALERT_ALARM_CASE_LIST", "alert.alarm.caseList");
        PERMISSON_KEY_MAP.put("XPROS_ALERT_ALARM_DEL", "alert.alarm.del");
        PERMISSON_KEY_MAP.put("XPROS_ALERT_ALARM_DOWNLOAD", "alert.alarm.download");
        PERMISSON_KEY_MAP.put("XPROS_ALERT_ALARM_EVENT_LIST", "alert.alarm.eventList");
        PERMISSON_KEY_MAP.put("XPROS_ALERT_RULES", "alert.rules");
        PERMISSON_KEY_MAP.put("XPROS_ALERT_RULES_LIST", "alert.rules.list");
        PERMISSON_KEY_MAP.put("XPROS_ALERT_RULES_ADD", "alert.rules.add");
        PERMISSON_KEY_MAP.put("XPROS_ALERT_RULES_EDIT", "alert.rules.edit");
        PERMISSON_KEY_MAP.put("XPROS_ALERT_RULES_DEL", "alert.rules.del");
        PERMISSON_KEY_MAP.put("XPROS_TEMPLATE", "template");
        PERMISSON_KEY_MAP.put("XPROS_TEMPLATE_PMA", "template.pma");
        PERMISSON_KEY_MAP.put("XPROS_TEMPLATE_PMA_PUBLIC", "template.pma.public");
        PERMISSON_KEY_MAP.put("XPROS_TEMPLATE_PMA_DOWNLOAD", "template.pma.dwonload");
        PERMISSON_KEY_MAP.put("XPROS_TEMPLATE_PMA_ORIGINAL", "template.pma.original");
        PERMISSON_KEY_MAP.put("XPROS_TEMPLATE_PMA_PUBLISH", "template.pma.publish");
        PERMISSON_KEY_MAP.put("XPROS_TEMPLATE_DC", "template.dc");
        PERMISSON_KEY_MAP.put("XPROS_TEMPLATE_DC_EXT", "template.dc.ext");
        PERMISSON_KEY_MAP.put("XPROS_TEMPLATE_DC_EXT_PUBLIC", "template.dc.ext.public");
        PERMISSON_KEY_MAP.put("XPROS_TEMPLATE_DC_EXT_DOWNLOAD", "template.dc.ext.dwonload");
        PERMISSON_KEY_MAP.put("XPROS_TEMPLATE_DC_EXT_ORIGINAL_LIST", "template.dc.ext.originalList");
        PERMISSON_KEY_MAP.put("XPROS_TEMPLATE_DC_EXT_PAGE_APPROVAL", "template.dc.ext.pageApproval");
        PERMISSON_KEY_MAP.put("XPROS_TEMPLATE_DC_TSF", "template.dc.tsf");
        PERMISSON_KEY_MAP.put("XPROS_TEMPLATE_DC_TSF_PUBLIC", "template.dc.tsf.public");
        PERMISSON_KEY_MAP.put("XPROS_TEMPLATE_DC_TSF_DOWNLOAD", "template.dc.tsf.dwonload");
        PERMISSON_KEY_MAP.put("XPROS_TEMPLATE_DC_TSF_ORIGINAL_LIST", "template.dc.tsf.originalList");
        PERMISSON_KEY_MAP.put("XPROS_TEMPLATE_DC_TSF_PAGE_APPROVAL", "template.dc.tsf.pageApproval");
        PERMISSON_KEY_MAP.put("XPROS_TEMPLATE_DC_MOD", "template.dc.mod");
        PERMISSON_KEY_MAP.put("XPROS_TEMPLATE_DC_MOD_PUBLIC", "template.dc.mod.public");
        PERMISSON_KEY_MAP.put("XPROS_TEMPLATE_DC_MOD_DOWNLOAD", "template.dc.mod.dwonload");
        PERMISSON_KEY_MAP.put("XPROS_TEMPLATE_DC_MOD_LIST_ORIGINAL_TEMPLATE", "template.dc.mod.listOriginalTemplate");
        PERMISSON_KEY_MAP.put("XPROS_TEMPLATE_DC_MOD_PAGE_APPROVAL", "template.dc.mod.pageApproval");
        PERMISSON_KEY_MAP.put("XPROS_TEMPLATE_WTIME", "template.wtime");
        PERMISSON_KEY_MAP.put("XPROS_TEMPLATE_WTIME_PUBLIC", "template.wtime.public");
        PERMISSON_KEY_MAP.put("XPROS_TEMPLATE_WTIME_DOWNLOAD", "template.wtime.dwonload");
        PERMISSON_KEY_MAP.put("XPROS_TEMPLATE_WTIME_ORIGINAL", "template.wtime.original");
        PERMISSON_KEY_MAP.put("XPROS_TEMPLATE_WTIME_PUBLISH", "template.wtime.publish");
    }

    public static boolean containsMenuKey(String menuKey){
        return PERMISSON_KEY_MAP.containsKey(menuKey);
    }

    public static String getMenuKey(String menuKey){
        return PERMISSON_KEY_MAP.get(menuKey);
    }
}
