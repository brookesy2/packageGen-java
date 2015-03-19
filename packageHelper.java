import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Helper class for packageGen. Contains Suffixes, Directories and Mappings
//This is not a complete list as the org did not have all features turned on
class packageHelper {

    public static Set<String> suffixHelper() {
        Set<String> suffixes;
        suffixes = Stream.of(
                "installedPackage",
                "labels",
                "resource",
                "scf",
                "component",
                "page",
                "queue",
                "dataSource",
                "role",
                "group",
                "object",
                "reportType",
                "report",
                "dashboard",
                "snapshot",
                "layout",
                "weblink",
                "quickAction",
                "flexipage",
                "tab",
                "customApplicationComponent",
                "app",
                "letter",
                "email",
                "flow",
                "workflow",
                "assignmentRules",
                "autoResponseRules",
                "escalationRules",
                "postTemplate",
                "approvalProcess",
                "homePageComponent",
                "homePageLayout",
                "objectTranslation",
                "cls",
                "trigger",
                "profile",
                "permissionset",
                "datacategorygroup",
                "remoteSite",
                "authprovider",
                "site",
                "sharingRules",
                "sharingRules",
                "sharingRules",
                "sharingRules",
                "sharingRules",
                "sharingRules",
                "sharingRules",
                "sharingRules",
                "community",
                "callCenter",
                "entitlementProcess",
                "milestoneType",
                "entitlementTemplate",
                "connectedApp",
                "network",
                "samlssoconfig",
                "synonymDictionary",
                "settings").collect(Collectors.toSet());

        return suffixes;
    }

    public static Set<String> directoryNameHelper() {
        Set<String> directoryNames;
        directoryNames = Stream.of(
                "installedPackages",
                "labels",
                "staticresources",
                "scontrols",
                "components",
                "pages",
                "queues",
                "dataSources",
                "roles",
                "groups",
                "objects",
                "reportTypes",
                "reports",
                "dashboards",
                "analyticSnapshots",
                "layouts",
                "weblinks",
                "quickActions",
                "flexipages",
                "tabs",
                "customApplicationComponents",
                "applications",
                "letterhead",
                "email",
                "flows",
                "workflows",
                "assignmentRules",
                "autoResponseRules",
                "escalationRules",
                "postTemplates",
                "approvalProcesses",
                "homePageComponents",
                "homePageLayouts",
                "objectTranslations",
                "classes",
                "triggers",
                "profiles",
                "permissionsets",
                "datacategorygroups",
                "remoteSiteSettings",
                "authproviders",
                "sites",
                "leadSharingRules",
                "campaignSharingRules",
                "caseSharingRules",
                "contactSharingRules",
                "opportunitySharingRules",
                "accountSharingRules",
                "customObjectSharingRules",
                "userSharingRules",
                "communities",
                "callCenters",
                "entitlementProcesses",
                "milestoneTypes",
                "entitlementTemplates",
                "connectedApps",
                "networks",
                "samlssoconfigs",
                "synonymDictionaries",
                "settings").collect(Collectors.toSet());

        return directoryNames;

    }

    public static Map<String, String> directoryMappingHelper() {
        Map<String, String> directoryMapping = new HashMap<>();

        directoryMapping.put("installedPackages", "InstalledPackage");
        directoryMapping.put("labels", "CustomLabels");
        directoryMapping.put("staticresources", "StaticResource");
        directoryMapping.put("scontrols", "Scontrol");
        directoryMapping.put("components", "ApexComponent");
        directoryMapping.put("pages", "ApexPage");
        directoryMapping.put("queues", "Queue");
        directoryMapping.put("dataSources", "ExternalDataSource");
        directoryMapping.put("roles", "Role");
        directoryMapping.put("groups", "Group");
        directoryMapping.put("objects", "CustomObject");
        directoryMapping.put("reportTypes", "ReportType");
        directoryMapping.put("reports", "Report");
        directoryMapping.put("dashboards", "Dashboard");
        directoryMapping.put("analyticSnapshots", "AnalyticSnapshot");
        directoryMapping.put("layouts", "Layout");
        directoryMapping.put("weblinks", "CustomPageWebLink");
        directoryMapping.put("quickActions", "QuickAction");
        directoryMapping.put("flexipages", "FlexiPage");
        directoryMapping.put("tabs", "CustomTab");
        directoryMapping.put("customApplicationComponents", "CustomApplicationComponent");
        directoryMapping.put("applications", "CustomApplication");
        directoryMapping.put("letterhead", "Letterhead");
        directoryMapping.put("email", "EmailTemplate");
        directoryMapping.put("flows", "Flow");
        directoryMapping.put("workflows", "Workflow");
        directoryMapping.put("assignmentRules", "AssignmentRules");
        directoryMapping.put("autoResponseRules", "AutoResponseRules");
        directoryMapping.put("escalationRules", "EscalationRules");
        directoryMapping.put("postTemplates", "PostTemplate");
        directoryMapping.put("approvalProcesses", "ApprovalProcess");
        directoryMapping.put("homePageComponents", "HomePageComponent");
        directoryMapping.put("homePageLayouts", "HomePageLayout");
        directoryMapping.put("objectTranslations", "CustomObjectTranslation");
        directoryMapping.put("classes", "ApexClass");
        directoryMapping.put("triggers", "ApexTrigger");
        directoryMapping.put("profiles", "Profile");
        directoryMapping.put("permissionsets", "PermissionSet");
        directoryMapping.put("datacategorygroups", "DataCategoryGroup");
        directoryMapping.put("remoteSiteSettings", "RemoteSiteSetting");
        directoryMapping.put("authproviders", "AuthProvider");
        directoryMapping.put("sites", "CustomSite");
        directoryMapping.put("leadSharingRules", "LeadSharingRules");
        directoryMapping.put("campaignSharingRules", "CampaignSharingRules");
        directoryMapping.put("caseSharingRules", "CaseSharingRules");
        directoryMapping.put("contactSharingRules", "ContactSharingRules");
        directoryMapping.put("opportunitySharingRules", "OpportunitySharingRules");
        directoryMapping.put("accountSharingRules", "AccountSharingRules");
        directoryMapping.put("customObjectSharingRules", "CustomObjectSharingRules");
        directoryMapping.put("userSharingRules", "UserSharingRules");
        directoryMapping.put("communities", "Community");
        directoryMapping.put("callCenters", "CallCenter");
        directoryMapping.put("entitlementProcesses", "EntitlementProcess");
        directoryMapping.put("milestoneTypes", "MilestoneType");
        directoryMapping.put("entitlementTemplates", "EntitlementTemplate");
        directoryMapping.put("connectedApps", "ConnectedApp");
        directoryMapping.put("networks", "Network");
        directoryMapping.put("samlssoconfigs", "SamlSsoConfig");
        directoryMapping.put("synonymDictionaries", "SynonymDictionary");
        directoryMapping.put("settings", "Settings");

        return directoryMapping;
    }
}
