package com.aprj.entities;

import javax.persistence.*;

/**
 * Created by southdom on 2017/4/19.
 */
@Entity
@Table(name = "emails")
public class Emails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String docNumber;
    private String metadataSubject;
    private String metadataTo;
    private String metadataFrom;
    private Integer senderPersonId;
    private String metadataDateSent;
    private String metadataDateReleased;
    private String metadataPdfLink;
    private String metadataCaseNumber;
    private String metadataDocumentClass;
    private String extractedSubject;
    private String extractedTo;
    private String extractedFrom;
    private String extractedCc;
    private String extractedDateSent;
    private String extractedCaseNumber;
    private String extractedDocNumber;
    private String extractedDateReleased;
    private String extractedReleaseInpartorfull;
    private String extractedBodyText;
    private String rawText;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public String getMetadataSubject() {
        return metadataSubject;
    }

    public void setMetadataSubject(String metadataSubject) {
        this.metadataSubject = metadataSubject;
    }

    public String getMetadataTo() {
        return metadataTo;
    }

    public void setMetadataTo(String metadataTo) {
        this.metadataTo = metadataTo;
    }

    public String getMetadataFrom() {
        return metadataFrom;
    }

    public void setMetadataFrom(String metadataFrom) {
        this.metadataFrom = metadataFrom;
    }

    public Integer getSenderPersonId() {
        return senderPersonId;
    }

    public void setSenderPersonId(Integer senderPersonId) {
        this.senderPersonId = senderPersonId;
    }

    public String getMetadataDateSent() {
        return metadataDateSent;
    }

    public void setMetadataDateSent(String metadataDateSent) {
        this.metadataDateSent = metadataDateSent;
    }

    public String getMetadataDateReleased() {
        return metadataDateReleased;
    }

    public void setMetadataDateReleased(String metadataDateReleased) {
        this.metadataDateReleased = metadataDateReleased;
    }

    public String getMetadataPdfLink() {
        return metadataPdfLink;
    }

    public void setMetadataPdfLink(String metadataPdfLink) {
        this.metadataPdfLink = metadataPdfLink;
    }

    public String getMetadataCaseNumber() {
        return metadataCaseNumber;
    }

    public void setMetadataCaseNumber(String metadataCaseNumber) {
        this.metadataCaseNumber = metadataCaseNumber;
    }

    public String getMetadataDocumentClass() {
        return metadataDocumentClass;
    }

    public void setMetadataDocumentClass(String metadataDocumentClass) {
        this.metadataDocumentClass = metadataDocumentClass;
    }

    public String getExtractedSubject() {
        return extractedSubject;
    }

    public void setExtractedSubject(String extractedSubject) {
        this.extractedSubject = extractedSubject;
    }

    public String getExtractedTo() {
        return extractedTo;
    }

    public void setExtractedTo(String extractedTo) {
        this.extractedTo = extractedTo;
    }

    public String getExtractedFrom() {
        return extractedFrom;
    }

    public void setExtractedFrom(String extractedFrom) {
        this.extractedFrom = extractedFrom;
    }

    public String getExtractedCc() {
        return extractedCc;
    }

    public void setExtractedCc(String extractedCc) {
        this.extractedCc = extractedCc;
    }

    public String getExtractedDateSent() {
        return extractedDateSent;
    }

    public void setExtractedDateSent(String extractedDateSent) {
        this.extractedDateSent = extractedDateSent;
    }

    public String getExtractedCaseNumber() {
        return extractedCaseNumber;
    }

    public void setExtractedCaseNumber(String extractedCaseNumber) {
        this.extractedCaseNumber = extractedCaseNumber;
    }

    public String getExtractedDocNumber() {
        return extractedDocNumber;
    }

    public void setExtractedDocNumber(String extractedDocNumber) {
        this.extractedDocNumber = extractedDocNumber;
    }

    public String getExtractedDateReleased() {
        return extractedDateReleased;
    }

    public void setExtractedDateReleased(String extractedDateReleased) {
        this.extractedDateReleased = extractedDateReleased;
    }

    public String getExtractedReleaseInpartorfull() {
        return extractedReleaseInpartorfull;
    }

    public void setExtractedReleaseInpartorfull(String extractedReleaseInpartorfull) {
        this.extractedReleaseInpartorfull = extractedReleaseInpartorfull;
    }

    public String getExtractedBodyText() {
        return extractedBodyText;
    }

    public void setExtractedBodyText(String extractedBodyText) {
        this.extractedBodyText = extractedBodyText;
    }

    public String getRawText() {
        return rawText;
    }

    public void setRawText(String rawText) {
        this.rawText = rawText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Emails emails = (Emails) o;

        if (!id.equals(emails.id)) return false;
        if (docNumber != null ? !docNumber.equals(emails.docNumber) : emails.docNumber != null) return false;
        if (metadataSubject != null ? !metadataSubject.equals(emails.metadataSubject) : emails.metadataSubject != null)
            return false;
        if (metadataTo != null ? !metadataTo.equals(emails.metadataTo) : emails.metadataTo != null) return false;
        if (metadataFrom != null ? !metadataFrom.equals(emails.metadataFrom) : emails.metadataFrom != null)
            return false;
        if (senderPersonId != null ? !senderPersonId.equals(emails.senderPersonId) : emails.senderPersonId != null)
            return false;
        if (metadataDateSent != null ? !metadataDateSent.equals(emails.metadataDateSent) : emails.metadataDateSent != null)
            return false;
        if (metadataDateReleased != null ? !metadataDateReleased.equals(emails.metadataDateReleased) : emails.metadataDateReleased != null)
            return false;
        if (metadataPdfLink != null ? !metadataPdfLink.equals(emails.metadataPdfLink) : emails.metadataPdfLink != null)
            return false;
        if (metadataCaseNumber != null ? !metadataCaseNumber.equals(emails.metadataCaseNumber) : emails.metadataCaseNumber != null)
            return false;
        if (metadataDocumentClass != null ? !metadataDocumentClass.equals(emails.metadataDocumentClass) : emails.metadataDocumentClass != null)
            return false;
        if (extractedSubject != null ? !extractedSubject.equals(emails.extractedSubject) : emails.extractedSubject != null)
            return false;
        if (extractedTo != null ? !extractedTo.equals(emails.extractedTo) : emails.extractedTo != null) return false;
        if (extractedFrom != null ? !extractedFrom.equals(emails.extractedFrom) : emails.extractedFrom != null)
            return false;
        if (extractedCc != null ? !extractedCc.equals(emails.extractedCc) : emails.extractedCc != null) return false;
        if (extractedDateSent != null ? !extractedDateSent.equals(emails.extractedDateSent) : emails.extractedDateSent != null)
            return false;
        if (extractedCaseNumber != null ? !extractedCaseNumber.equals(emails.extractedCaseNumber) : emails.extractedCaseNumber != null)
            return false;
        if (extractedDocNumber != null ? !extractedDocNumber.equals(emails.extractedDocNumber) : emails.extractedDocNumber != null)
            return false;
        if (extractedDateReleased != null ? !extractedDateReleased.equals(emails.extractedDateReleased) : emails.extractedDateReleased != null)
            return false;
        if (extractedReleaseInpartorfull != null ? !extractedReleaseInpartorfull.equals(emails.extractedReleaseInpartorfull) : emails.extractedReleaseInpartorfull != null)
            return false;
        if (extractedBodyText != null ? !extractedBodyText.equals(emails.extractedBodyText) : emails.extractedBodyText != null)
            return false;
        return rawText != null ? rawText.equals(emails.rawText) : emails.rawText == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (docNumber != null ? docNumber.hashCode() : 0);
        result = 31 * result + (metadataSubject != null ? metadataSubject.hashCode() : 0);
        result = 31 * result + (metadataTo != null ? metadataTo.hashCode() : 0);
        result = 31 * result + (metadataFrom != null ? metadataFrom.hashCode() : 0);
        result = 31 * result + (senderPersonId != null ? senderPersonId.hashCode() : 0);
        result = 31 * result + (metadataDateSent != null ? metadataDateSent.hashCode() : 0);
        result = 31 * result + (metadataDateReleased != null ? metadataDateReleased.hashCode() : 0);
        result = 31 * result + (metadataPdfLink != null ? metadataPdfLink.hashCode() : 0);
        result = 31 * result + (metadataCaseNumber != null ? metadataCaseNumber.hashCode() : 0);
        result = 31 * result + (metadataDocumentClass != null ? metadataDocumentClass.hashCode() : 0);
        result = 31 * result + (extractedSubject != null ? extractedSubject.hashCode() : 0);
        result = 31 * result + (extractedTo != null ? extractedTo.hashCode() : 0);
        result = 31 * result + (extractedFrom != null ? extractedFrom.hashCode() : 0);
        result = 31 * result + (extractedCc != null ? extractedCc.hashCode() : 0);
        result = 31 * result + (extractedDateSent != null ? extractedDateSent.hashCode() : 0);
        result = 31 * result + (extractedCaseNumber != null ? extractedCaseNumber.hashCode() : 0);
        result = 31 * result + (extractedDocNumber != null ? extractedDocNumber.hashCode() : 0);
        result = 31 * result + (extractedDateReleased != null ? extractedDateReleased.hashCode() : 0);
        result = 31 * result + (extractedReleaseInpartorfull != null ? extractedReleaseInpartorfull.hashCode() : 0);
        result = 31 * result + (extractedBodyText != null ? extractedBodyText.hashCode() : 0);
        result = 31 * result + (rawText != null ? rawText.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Emails{" +
                "id=" + id +
                ", docNumber='" + docNumber + '\'' +
                ", metadataSubject='" + metadataSubject + '\'' +
                ", metadataTo='" + metadataTo + '\'' +
                ", metadataFrom='" + metadataFrom + '\'' +
                ", senderPersonId=" + senderPersonId +
                ", metadataDateSent='" + metadataDateSent + '\'' +
                ", metadataDateReleased='" + metadataDateReleased + '\'' +
                ", metadataPdfLink='" + metadataPdfLink + '\'' +
                ", metadataCaseNumber='" + metadataCaseNumber + '\'' +
                ", metadataDocumentClass='" + metadataDocumentClass + '\'' +
                ", extractedSubject='" + extractedSubject + '\'' +
                ", extractedTo='" + extractedTo + '\'' +
                ", extractedFrom='" + extractedFrom + '\'' +
                ", extractedCc='" + extractedCc + '\'' +
                ", extractedDateSent='" + extractedDateSent + '\'' +
                ", extractedCaseNumber='" + extractedCaseNumber + '\'' +
                ", extractedDocNumber='" + extractedDocNumber + '\'' +
                ", extractedDateReleased='" + extractedDateReleased + '\'' +
                ", extractedReleaseInpartorfull='" + extractedReleaseInpartorfull + '\'' +
                ", extractedBodyText='" + extractedBodyText + '\'' +
                ", rawText='" + rawText + '\'' +
                '}';
    }

}
