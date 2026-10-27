-- ----------------------------
-- Table structure for os_group
-- ----------------------------
DROP TABLE IF EXISTS "platform_db"."os_group";
CREATE TABLE "platform_db"."os_group"
(
    "GROUP_ID_"              varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
    "DIM_ID_"                varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
    "NAME_"                  varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
    "PIN_YIN_"               varchar(40) COLLATE "pg_catalog"."default",
    "KEY_"                   varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
    "RANK_LEVEL_"            int4                                       NOT NULL,
    "STATUS_"                varchar(43) COLLATE "pg_catalog"."default" NOT NULL,
    "DESCP_"                 varchar(255) COLLATE "pg_catalog"."default",
    "SN_"                    int4,
    "PARENT_ID_"             varchar(64) COLLATE "pg_catalog"."default",
    "PATH_"                  varchar(200) COLLATE "pg_catalog"."default",
    "AREA_CODE_"             varchar(50) COLLATE "pg_catalog"."default",
    "FORM_"                  varchar(20) COLLATE "pg_catalog"."default",
    "SYNC_WX_"               int4,
    "WX_PARENT_PID_"         int4,
    "WX_PID_"                int4,
    "IS_DEFAULT_"            varchar(40) COLLATE "pg_catalog"."default",
    "DD_PARENT_ID_"          varchar(64) COLLATE "pg_catalog"."default",
    "DD_ID_"                 varchar(64) COLLATE "pg_catalog"."default",
    "IS_LEAF_"               char(1) COLLATE "pg_catalog"."default",
    "TYPE_"                  int4,
    "SHORT_NAME_"            varchar(64) COLLATE "pg_catalog"."default",
    "DELETED_"               int4,
    "COMPANY_ID_"            varchar(32) COLLATE "pg_catalog"."default",
    "TENANT_ID_"             varchar(64) COLLATE "pg_catalog"."default",
    "CREATE_DEP_ID_"         varchar(64) COLLATE "pg_catalog"."default",
    "CREATE_BY_"             varchar(64) COLLATE "pg_catalog"."default",
    "CREATE_TIME_"           timestamp(6),
    "UPDATE_BY_"             varchar(64) COLLATE "pg_catalog"."default",
    "UPDATE_TIME_"           timestamp(6),
    "SYNC_SOURCE_ID_"        varchar(100) COLLATE "pg_catalog"."default",
    "DATA_SCAPE_"            int4,
    "MAIN_SYSTEM_GROUP_ID_"  varchar(64) COLLATE "pg_catalog"."default",
    "REVOCATION_STATUS_"     varchar(64) COLLATE "pg_catalog"."default",
    "TIME_SYNC_"             timestamp(6),
    "APP_IDS_"               varchar(255) COLLATE "pg_catalog"."default",
    "DEP_IDS_"               varchar(255) COLLATE "pg_catalog"."default",
    "IS_HAND_HELD_TERMINAL_" varchar(255) COLLATE "pg_catalog"."default",
    "PRO_ID_"                varchar(255) COLLATE "pg_catalog"."default"
)
;
COMMENT
ON COLUMN "platform_db"."os_group"."GROUP_ID_" IS '用户组ID';
COMMENT
ON COLUMN "platform_db"."os_group"."DIM_ID_" IS '维度ID（1 部门2角色3流程角色）';
COMMENT
ON COLUMN "platform_db"."os_group"."NAME_" IS '用户组名称';
COMMENT
ON COLUMN "platform_db"."os_group"."PIN_YIN_" IS '拼音';
COMMENT
ON COLUMN "platform_db"."os_group"."KEY_" IS '用户组业务主键';
COMMENT
ON COLUMN "platform_db"."os_group"."RANK_LEVEL_" IS '所属用户组等级值';
COMMENT
ON COLUMN "platform_db"."os_group"."STATUS_" IS '状态 inmaevg 未激活';
COMMENT
ON COLUMN "platform_db"."os_group"."DESCP_" IS '描述';
COMMENT
ON COLUMN "platform_db"."os_group"."SN_" IS '排序号';
COMMENT
ON COLUMN "platform_db"."os_group"."PARENT_ID_" IS '父用户组ID';
COMMENT
ON COLUMN "platform_db"."os_group"."PATH_" IS '路径';
COMMENT
ON COLUMN "platform_db"."os_group"."AREA_CODE_" IS '区域编码';
COMMENT
ON COLUMN "platform_db"."os_group"."FORM_" IS '来源  system';
COMMENT
ON COLUMN "platform_db"."os_group"."SYNC_WX_" IS '同步到微信';
COMMENT
ON COLUMN "platform_db"."os_group"."WX_PARENT_PID_" IS '微信平台部门唯一ID';
COMMENT
ON COLUMN "platform_db"."os_group"."WX_PID_" IS '是否为';
COMMENT
ON COLUMN "platform_db"."os_group"."IS_DEFAULT_" IS '是否默认 ，嗲表系统';
COMMENT
ON COLUMN "platform_db"."os_group"."DD_PARENT_ID_" IS '钉钉父ID';
COMMENT
ON COLUMN "platform_db"."os_group"."DD_ID_" IS '钉钉ID';
COMMENT
ON COLUMN "platform_db"."os_group"."IS_LEAF_" IS '是否为子';
COMMENT
ON COLUMN "platform_db"."os_group"."TYPE_" IS '组织类型 1代表公司 2代表部门';
COMMENT
ON COLUMN "platform_db"."os_group"."SHORT_NAME_" IS '简称';
COMMENT
ON COLUMN "platform_db"."os_group"."DELFTED_" IS '逻辑删除';
COMMENT
ON COLUMN "platform_db"."os_group"."COMPANY_ID_" IS '用户ID';
COMMENT
ON COLUMN "platform_db"."os_group"."TENANT_ID_" IS '租用用户id';
COMMENT
ON COLUMN "platform_db"."os_group"."DATA_SCAPE_" IS '角色权限控制（0无；1部门级；2所级）';
COMMENT
ON COLUMN "platform_db"."os_group"."MAIN_SYSTEM_GROUP_ID_" IS '主席台部门id';
COMMENT
ON COLUMN "platform_db"."os_group"."REVOCATION_STATUS_" IS '撤销状态';
COMMENT
ON COLUMN "platform_db"."os_group"."TIME_SYNC_" IS '同步时间';
COMMENT
ON COLUMN "platform_db"."os_group"."APP_IDS_" IS '所属应用';
COMMENT
ON COLUMN "platform_db"."os_group"."DEP_IDS_" IS '所属部门';
COMMENT
ON COLUMN "platform_db"."os_group"."IS_HAND_HELD_TERMINAL_" IS '是否用于手持终端';
COMMENT
ON COLUMN "platform_db"."os_group"."PRO_ID_" IS '公司ID';
COMMENT
ON TABLE "platform_db"."os_group" IS '用户组';

-- ----------------------------
-- Table structure for os_group_menu
-- ----------------------------
DROP TABLE IF EXISTS "platform_db"."os_group_menu";
CREATE TABLE "platform_db"."os_group_menu"
(
    "ID_"          varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
    "GROUP_ID_"    varchar(64) COLLATE "pg_catalog"."default"  NOT NULL,
    "MENU_ID_"     varchar(64) COLLATE "pg_catalog"."default"  NOT NULL,
    "NAME_"        varchar(64) COLLATE "pg_catalog"."default"  NOT NULL,
    "BO_LIST_KEY_" varchar(40) COLLATE "pg_catalog"."default",
    "MENU_KEY_"    varchar(64) COLLATE "pg_catalog"."default"  NOT NULL
)
;
COMMENT
ON TABLE "platform_db"."os_group_menu" IS '用户组';

-- ----------------------------
-- Table structure for os_platform_audit_info
-- ----------------------------
DROP TABLE IF EXISTS "platform_db"."sys_log";
CREATE TABLE "platform_db"."sys_log"
(
    "ID_"                      varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
    "APP_NAME_"                varchar(64) COLLATE "pg_catalog"."default",
    "MODULE_"                  varchar(64) COLLATE "pg_catalog"."default",
    "SUB_MODULE_"              varchar(64) COLLATE "pg_catalog"."default",
    "CLASS_NAME_"              varchar(128) COLLATE "pg_catalog"."default",
    "METHOD_NAME_"             varchar(64) COLLATE "pg_catalog"."default",
    "ACTION_"                  varchar(64) COLLATE "pg_catalog"."default",
    "PK_VALUE_"                varchar(64) COLLATE "pg_catalog"."default",
    "IP_"                      varchar(40) COLLATE "pg_catalog"."default",
    "DETAIL_"                  text COLLATE "pg_catalog"."default",
    "OPERATION_"               varchar(2000) COLLATE "pg_catalog"."default",
    "USER_NAME_"               varchar(40) COLLATE "pg_catalog"."default",
    "DURATION_"                int4                                       NOT NULL,
    "CREATE_DEP_ID_"           varchar(64) COLLATE "pg_catalog"."default",
    "DELETED_"                 int4,
    "COMPANY_ID_"              varchar(30) COLLATE "pg_catalog"."default",
    "TENANT_ID_"               varchar(64) COLLATE "pg_catalog"."default",
    "CREATE_BY_"               varchar(64) COLLATE "pg_catalog"."default",
    "CREATE_TIME_"             timestamp(6),
    "UPDATE_BY_"               varchar(64) COLLATE "pg_catalog"."default",
    "UPDATE_TIME_"             timestamp(6),
    "BUS_TYPE_"                varchar(32) COLLATE "pg_catalog"."default",
    "IS_RESUME_"               varchar(4) COLLATE "pg_catalog"."default",
    "SM_SEC_LEVEL_"            varchar(50) COLLATE "pg_catalog"."default",
    "OPT_USER_NO_"             varchar(50) COLLATE "pg_catalog"."default",
    "LOG_TYPE_"                varchar(128) COLLATE "pg_catalog"."default",
    "OPERATE_ON_"              varchar(128) COLLATE "pg_catalog"."default",
    "OPERATE_ON_SM_SEC_LEVEL_" varchar(128) COLLATE "pg_catalog"."default",
    "OPERATION_RESULT_"        varchar(255) COLLATE "pg_catalog"."default",
    "PRO_TYPE_"                varchar(255) COLLATE "pg_catalog"."default"
)
;
COMMENT
ON COLUMN "platform_db"."sys_log"."ID_" IS '编号';
COMMENT
ON COLUMN "platform_db"."sys_log"."APP_NAME_" IS '应用名称';
COMMENT
ON COLUMN "platform_db"."sys_log"."MODULE_" IS '一级模块';
COMMENT
ON COLUMN "platform_db"."sys_log"."SUB_MODULE_" IS '子模块';
COMMENT
ON COLUMN "platform_db"."sys_log"."CLASS_NAME_" IS '类名';
COMMENT
ON COLUMN "platform_db"."sys_log"."METHOD_NAME_" IS '方法名';
COMMENT
ON COLUMN "platform_db"."sys_log"."ACTION_" IS '动作';
COMMENT
ON COLUMN "platform_db"."sys_log"."DETAIL_" IS '日志明细';
COMMENT
ON COLUMN "platform_db"."sys_log"."OPERATION_" IS '操作';
COMMENT
ON COLUMN "platform_db"."sys_log"."USER_NAME_" IS '操作用户';
COMMENT
ON COLUMN "platform_db"."sys_log"."DURATION_" IS '操作时长';
COMMENT
ON COLUMN "platform_db"."sys_log"."CREATE_DEP_ID_" IS '创建部门ID';
COMMENT
ON COLUMN "platform_db"."sys_log"."DELETED_" IS '逻辑删除';
COMMENT
ON COLUMN "platform_db"."sys_log"."COMPANY_ID" IS '公司ID';
COMMENT
ON COLUMN "platform_db"."sys_log"."TENANT_ID" IS '租户ID';
COMMENT
ON COLUMN "platform_db"."sys_log"."CREATE_BY_" IS '创建人';
COMMENT
ON COLUMN "platform_db"."sys_log"."CREATE_TIME_" IS '创建时间';
COMMENT
ON COLUMN "platform_db"."sys_log"."UPDATE_BY_" IS '更新人';
COMMENT
ON COLUMN "platform_db"."sys_log"."UPDATE_TIME_" IS '更新时间';
COMMENT
ON COLUMN "platform_db"."sys_log"."BUS_TYPE_" IS '业务类型';
COMMENT
ON COLUMN "platform_db"."sys_log"."IS_RESUMME_" IS '是否已恢复';
COMMENT
ON COLUMN "platform_db"."sys_log"."SM_SEC_LEVEL" IS '用户密级';
COMMENT
ON COLUMN "platform_db"."sys_log"."OPT_USER_NO_" IS '操作人编码';
COMMENT
ON COLUMN "platform_db"."sys_log"."LOG_TYPE_" IS '操作日志';
COMMENT
ON COLUMN "platform_db"."sys_log"."OPERATE_ON_" IS '操作对象';
COMMENT
ON COLUMN "platform_db"."sys_log"."OPERATE_ON_SM_SEC_LEVEL_" IS '操作对象密级';
COMMENT
ON COLUMN "platform_db"."sys_log"."OPERATION_RESULT_" IS '操作结果';
COMMENT
ON COLUMN "platform_db"."sys_log"."PK_VALUE_" IS '业务主键';
COMMENT
ON TABLE "platform_db"."sys_log" IS '日志';

-- ----------------------------
-- Table structure for os_rel_inst
-- ----------------------------
DROP TABLE IF EXISTS "platform_db"."os_rel_inst";
CREATE TABLE "platform_db"."os_rel_inst"
(
    "INST_ID_"       varchar(64) COLLATE "pg_catalog"."default",
    "REL_TYPE_ID_"   varchar(64) COLLATE "pg_catalog"."default",
    "REL_TYPE_KEY_"  varchar(64) COLLATE "pg_catalog"."default",
    "PARTY1_"        varchar(64) COLLATE "pg_catalog"."default",
    "PARTY2_"        varchar(64) COLLATE "pg_catalog"."default",
    "DIM1_"          varchar(64) COLLATE "pg_catalog"."default",
    "DIM2_"          varchar(64) COLLATE "pg_catalog"."default",
    "IS_MAIN_"       varchar(20) COLLATE "pg_catalog"."default",
    "STATUS_"        varchar(40) COLLATE "pg_catalog"."default",
    "ALIAS_"         varchar(80) COLLATE "pg_catalog"."default",
    "REL_TYPE_"      varchar(64) COLLATE "pg_catalog"."default",
    "PATH_"          varchar(20) COLLATE "pg_catalog"."default",
    "DELETED_"       int4,
    "COMPANY_ID_"    varchar(30) COLLATE "pg_catalog"."default",
    "TENANT_ID_"     varchar(64) COLLATE "pg_catalog"."default",
    "CREATE_DEP_ID_" varchar(64) COLLATE "pg_catalog"."default",
    "CREATE_BY_"     varchar(64) COLLATE "pg_catalog"."default",
    "CREATE_TIME_"   timestamp(6),
    "UPDATE_BY_"     varchar(64) COLLATE "pg_catalog"."default",
    "UPDATE_TIME_"   timestamp(6),
    "TIME_SYNC_"     timestamp(6),
    "PRO_JD_"        varchar(64) COLLATE "pg_catalog"."default"
)
;
COMMENT
ON COLUMN "platform_db"."os_rel_ins"."INST_ID_" IS '用户组关系ID';
COMMENT
ON COLUMN "platform_db"."os_rel_ins"."REL_TYPE_ID_" IS '关系类刑ID';
COMMENT
ON COLUMN "platform_db"."os_rel_ins"."REL_TYPE_KEY_" IS '关系类刑KEY';
COMMENT
ON COLUMN "platform_db"."os_rel_ins"."PARTY1_" IS '当前方ID（用户组Id）';
COMMENT
ON COLUMN "platform_db"."os_rel_ins"."PARTY2_" IS '关联方ID（如用户）';
COMMENT
ON COLUMN "platform_db"."os_rel_ins"."DIM1_" IS '当前方维度';
COMMENT
ON COLUMN "platform_db"."os_rel_ins"."DIM2_" IS '关联方维度ID';
COMMENT
ON COLUMN "platform_db"."os_rel_ins"."IS_MAIN_" IS '是否为主关系';
COMMENT
ON COLUMN "platform_db"."os_rel_ins"."STATUS_" IS '状态 ENABLED  DISABLED';
COMMENT
ON COLUMN "platform_db"."os_rel_ins"."ALIAS_" IS '别名';
COMMENT
ON COLUMN "platform_db"."os_rel_ins"."REL_TYPE_" IS '关系类型';
COMMENT
ON COLUMN "platform_db"."os_rel_ins"."PATH_" IS '路径';
COMMENT
ON COLUMN "platform_db"."os_rel_ins"."DELETED_" IS '逻辑删除';
COMMENT
ON COLUMN "platform_db"."os_rel_ins"."COMPANY_ID_" IS '公司ID';
COMMENT
ON COLUMN "platform_db"."os_rel_ins"."TENANT_ID_" IS '租用用户d';
COMMENT
ON COLUMN "platform_db"."os_rel_ins"."CREATE_DEP_ID_" IS '创建部门ID';
COMMENT
ON COLUMN "platform_db"."os_rel_ins"."CREATE_BY_" IS '创建人ID';
COMMENT
ON COLUMN "platform_db"."os_rel_ins"."CREATE_TIME_" IS '创建时间';
COMMENT
ON COLUMN "platform_db"."os_rel_ins"."UPDATE_BY_" IS '更新人ID';
COMMENT
ON COLUMN "platform_db"."os_rel_ins"."UPDATE_TIME_" IS '更新时间';
COMMENT
ON COLUMN "platform_db"."os_rel_ins"."TIME_SYNC_" IS '同步时间';
COMMENT
ON COLUMN "platform_db"."os_rel_ins"."PRO_JD_" IS '项目ID';
COMMENT
ON TABLE "platform_db"."os_rel_ins" IS '用户关系';

-- ----------------------------
-- Table structure for os_user
-- ----------------------------
DROP TABLE IF EXISTS "platform_db"."os_user";
CREATE TABLE "platform_db"."os_user"
(
    "USER_ID_"            varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
    "FULLNAME_"           varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
    "PIN_YIN_"            varchar(40) COLLATE "pg_catalog"."default",
    "USER_NO_"            varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
    "PWD_"                varchar(64) COLLATE "pg_catalog"."default",
    "ENTRY_TIME_"         timestamp(6),
    "QUIT_TIME_"          timestamp(6),
    "USER_TYPE_"          varchar(20) COLLATE "pg_catalog"."default",
    "FROM_"               varchar(20) COLLATE "pg_catalog"."default",
    "BIRTHDAY_"           timestamp(6),
    "SEX_"                varchar(10) COLLATE "pg_catalog"."default",
    "MOBILE_"             varchar(32) COLLATE "pg_catalog"."default",
    "EMAIL_"              varchar(100) COLLATE "pg_catalog"."default",
    "ADDRESS_"            varchar(255) COLLATE "pg_catalog"."default",
    "URGENT_"             varchar(64) COLLATE "pg_catalog"."default",
    "SYNC_WX_"            int4,
    "URGENT_MOBILE_"      varchar(20) COLLATE "pg_catalog"."default",
    "QQ_"                 varchar(20) COLLATE "pg_catalog"."default",
    "PHOTO_"              varchar(255) COLLATE "pg_catalog"."default",
    "ENABLED_"            varchar(64) COLLATE "pg_catalog"."default",
    "DD_ID_"              varchar(64) COLLATE "pg_catalog"."default",
    "OPENID_"             varchar(64) COLLATE "pg_catalog"."default",
    "WX_OPEN_ID_"        varchar(64) COLLATE "pg_catalog"."default",
    "IS_LOCK_"            varchar(10) COLLATE "pg_catalog"."default",
    "STATUS_"             varchar(50) COLLATE "pg_catalog"."default",
    "PWD_UPDATE_TIME_"     timestamp(6),
    "SN_"                 int4,
    "IS_FIRST_LOGIN_"     varchar(10) COLLATE "pg_catalog"."default",
    "DELETED_"            int4,
    "COMPANY_ID_"         varchar(64) COLLATE "pg_catalog"."default",
    "TENANT_ID_"          varchar(64) COLLATE "pg_catalog"."default",
    "CREATE_DEP_ID_"      varchar(64) COLLATE "pg_catalog"."default",
    "CREATE_BY_"          varchar(64) COLLATE "pg_catalog"."default",
    "CREATE_TIME_"        timestamp(6),
    "UPDATE_BY_"          varchar(64) COLLATE "pg_catalog"."default",
    "UPDATE_TIME_"        timestamp(6),
    "SM_SEC_LEVEL"       varchar(50) COLLATE "pg_catalog"."default",
    "SYNC_SOURCE_ID_"     varchar(100) COLLATE "pg_catalog"."default",
    "USER_CODE_"          varchar(50) COLLATE "pg_catalog"."default",
    "REF_USER_ID_"        varchar(64) COLLATE "pg_catalog"."default",
    "ACC_TYPE_"           varchar(50) COLLATE "pg_catalog"."default",
    "MAIN_SYSTEM_USER_ID_" varchar(64) COLLATE "pg_catalog"."default",
    "PERMISSION_"         varchar(11) COLLATE "pg_catalog"."default",
    "IS_WX_"              int4,
    "TIME_SYNC_"          timestamp(6),
    "ID_NUMBER_"          varchar(50) COLLATE "pg_catalog"."default",
    "DEGREES_"            varchar(10) COLLATE "pg_catalog"."default",
    "FINANCIAL_CODING_"   varchar(50) COLLATE "pg_catalog"."default",
    "POST_"               varchar(50) COLLATE "pg_catalog"."default"
)
;
COMMENT
ON COLUMN "platform_db"."os_user"."USER_ID_" IS '用户ID';
COMMENT
ON COLUMN "platform_db"."os_user"."FULLNAME_" IS '姓名';
COMMENT
ON COLUMN "platform_db"."os_user"."PIN_YIN_" IS '拼音';
COMMENT
ON COLUMN "platform_db"."os_user"."USER_NO_" IS '用户编号';
COMMENT
ON COLUMN "platform_db"."os_user"."PWD_" IS '密码';
COMMENT
ON COLUMN "platform_db"."os_user"."ENTRY_TIME_" IS '入职时间';
COMMENT
ON COLUMN "platform_db"."os_user"."QUIT_TIME_" IS '离职时间';
COMMENT
ON COLUMN "platform_db"."os_user"."USER_TYPE_" IS '用户类型';
COMMENT
ON COLUMN "platform_db"."os_user"."FROM_" IS '来源 system,系统添加,import,导入,grade,分级';
COMMENT
ON COLUMN "platform_db"."os_user"."BIRTHDAY_" IS '出生日期';
COMMENT
ON COLUMN "platform_db"."os_user"."SEX_" IS '姓别';
COMMENT
ON COLUMN "platform_db"."os_user"."MOBILE_" IS '手机';
COMMENT
ON COLUMN "platform_db"."os_user"."EMAIL_" IS '邮件';
COMMENT
ON COLUMN "platform_db"."os_user"."ADDRESS_" IS '地址';
COMMENT
ON COLUMN "platform_db"."os_user"."URGENT_" IS '紧急联系人';
COMMENT
ON COLUMN "platform_db"."os_user"."SYNC_WX_" IS '是否同步到微信';
COMMENT
ON COLUMN "platform_db"."os_user"."URGENT_MOBILE_" IS '紧急联系人手机';
COMMENT
ON COLUMN "platform_db"."os_user"."QQ_" IS 'QQ号';
COMMENT
ON COLUMN "platform_db"."os_user"."PHOTO_" IS '照片';
COMMENT
ON COLUMN "platform_db"."os_user"."ENABLED_" IS '是否允许';
COMMENT
ON COLUMN "platform_db"."os_user"."DD_ID_" IS '钉钉ID';
COMMENT
ON COLUMN "platform_db"."os_user"."WX_OPENI_ID_" IS '企业数信OPENID';
COMMENT
ON COLUMN "platform_db"."os_user"."IS_LOCK_" IS '账号是否锁定';
COMMENT
ON COLUMN "platform_db"."os_user"."STATUS_" IS '用户在当前机构的状志';
COMMENT
ON COLUMN "platform_db"."os_user"."PWD_UPDATE_TME_" IS '密码修改时闻';
COMMENT
ON COLUMN "platform_db"."os_user"."SN_" IS '序号';
COMMENT
ON COLUMN "platform_db"."os_user"."IS_FIRST_LOGIN_" IS '用户是否首次登录';
COMMENT
ON COLUMN "platform_db"."os_user"."DELETED_" IS '逻辑删除';
COMMENT
ON COLUMN "platform_db"."os_user"."COMPANY_ID_" IS '公司ID';
COMMENT
ON COLUMN "platform_db"."os_user"."TENANT_ID_" IS '租用用户ID';
COMMENT
ON COLUMN "platform_db"."os_user"."CREATE_DEP_ID_" IS '创建部门ID';
COMMENT
ON COLUMN "platform_db"."os_user"."CREATE_BY_" IS '创建人';
COMMENT
ON COLUMN "platform_db"."os_user"."CREATE_TTME_" IS '创建时间';
COMMENT
ON COLUMN "platform_db"."os_user"."UPDATE_BY_" IS '更新 人ID';
COMMENT
ON COLUMN "platform_db"."os_user"."UPDATE_TIME_" IS '更新时间';
COMMENT
ON COLUMN "platform_db"."os_user"."SM_SEC_LEVEL_" IS '密级';
COMMENT
ON COLUMN "platform_db"."os_user"."SYNC_SOURCE_ID_" IS '数据同步来源1D';
COMMENT
ON COLUMN "platform_db"."os_user"."USER_CODE_" IS '员工工号';
COMMENT
ON COLUMN "platform_db"."os_user"."REF_USER_ID_" IS '关联的主用户ID';
COMMENT
ON COLUMN "platform_db"."os_user"."ACC_TYPE_" IS '账号类型';
COMMENT
ON COLUMN "platform_db"."os_user"."MAIN_SYSTEM_USERID_" IS '主系统用户ID';
COMMENT
ON COLUMN "platform_db"."os_user"."PERMISSION_" IS 'wps艾档投服';
COMMENT
ON COLUMN "platform_db"."os_user"."IS_WX_" IS '是否是外协';
COMMENT
ON COLUMN "platform_db"."os_user"."TIME_SYNC_" IS '同步时间';
COMMENT
ON COLUMN "platform_db"."os_user"."ID_NUMBER_" IS '身份证号';
COMMENT
ON COLUMN "platform_db"."os_user"."DEGREES_" IS '学历(码表)';
COMMENT
ON COLUMN "platform_db"."os_user"."FINANCIAL_CODING_" IS '财务编码';
COMMENT
ON COLUMN "platform_db"."os_user"."POST_" IS '岗位';
COMMENT
ON TABLE "platform_db"."os_user" IS '用户信息';

-- ----------------------------
-- Primary Key structure for table os_group
-- ----------------------------
ALTER TABLE "platform_db"."os_group" ADD CONSTRAINT "os_group_pkey" PRIMARY KEY ("GROUP_ID_");

-- ----------------------------
-- Primary Key structure for table os_group_menu
-- ----------------------------
ALTER TABLE "platform_db"."os_group_menu" ADD CONSTRAINT "os_group_menu_pkey" PRIMARY KEY ("ID_");

-- ----------------------------
-- Primary Key structure for table os_platform_audit_info
-- ----------------------------
ALTER TABLE "platform_db"."os_platform_audit_info" ADD CONSTRAINT "os_platform_audit_info_pkey" PRIMARY KEY ("ID_");

-- ----------------------------
-- Primary Key structure for table os_user
-- ----------------------------
ALTER TABLE "platform_db"."os_user" ADD CONSTRAINT "os_user_pkey" PRIMARY KEY ("USER_ID_");