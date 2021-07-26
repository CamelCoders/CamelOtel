package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Models;

public class AuditTrailModel {
    String trailCategory, auditTrailDescription, auditTrailSource, auditTrailTime,
            auditTrailIPAddress;

    public AuditTrailModel(String trailCategory, String auditTrailDescription, String auditTrailSource, String auditTrailTime, String auditTrailIPAddress) {
        this.trailCategory = trailCategory;
        this.auditTrailDescription = auditTrailDescription;
        this.auditTrailSource = auditTrailSource;
        this.auditTrailTime = auditTrailTime;
        this.auditTrailIPAddress = auditTrailIPAddress;
    }

    public String getTrailCategory() {
        return trailCategory;
    }

    public void setTrailCategory(String trailCategory) {
        this.trailCategory = trailCategory;
    }

    public String getAuditTrailDescription() {
        return auditTrailDescription;
    }

    public void setAuditTrailDescription(String auditTrailDescription) {
        this.auditTrailDescription = auditTrailDescription;
    }

    public String getAuditTrailSource() {
        return auditTrailSource;
    }

    public void setAuditTrailSource(String auditTrailSource) {
        this.auditTrailSource = auditTrailSource;
    }

    public String getAuditTrailTime() {
        return auditTrailTime;
    }

    public void setAuditTrailTime(String auditTrailTime) {
        this.auditTrailTime = auditTrailTime;
    }

    public String getAuditTrailIPAddress() {
        return auditTrailIPAddress;
    }

    public void setAuditTrailIPAddress(String auditTrailIPAddress) {
        this.auditTrailIPAddress = auditTrailIPAddress;
    }
}

