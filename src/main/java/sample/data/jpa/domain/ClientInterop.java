package com.bloodhound.domain;

import org.hibernate.annotations.Cache;

import javax.persistence.*;
import java.io.Serializable;

import static org.hibernate.annotations.CacheConcurrencyStrategy.READ_ONLY;

/**
 *  @author
 */
@Entity
@Cache(usage = READ_ONLY)
@Table(schema = "HCIUSER", name = "HCICLIENT_IOP")
public class ClientInterop implements Serializable {

    @Id
    @Column(name = "CLIENTCODE", length = 5, nullable = false)
    private String clientCode;

    @Column(name = "PREFIX_CLAIM_NUMBER")
    private Character prefixClaimNumber;

    @Column(name = "PREFIX_PROVIDER_NUMBER")
    private Character prefixProviderNumber;

    @Column(name = "PREFIX_PATIENT_NUMBER")
    private Character prefixPatientNumber;

    @Column(name = "CLIENT_PROCESSOR")
    private Character clientProcessor;

    @Column(name = "DBNAME")
    private String dbName;

    @Column(name = "DBUSER")
    private String dbUser;

    @Column(name = "DBPSWD")
    private String dbPswd;

    @Column(name = "DBURL")
    private String dbUrl;

    @Column(name = "DBPSWD_ENCRYPT")
    private Character passwordEncrypted;

    @OneToOne
    @JoinColumn(name = "CLIENTCODE")
    private ClientGrouping ClientGrouping;

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public void setPrefixClaimNumber(Character prefixClaimNumber) {
        this.prefixClaimNumber = prefixClaimNumber;
    }

    public Boolean isPrefixClaimNumber() {
        if (null != this.prefixClaimNumber) {
            return this.prefixClaimNumber.compareTo('T') == 0 ? Boolean.TRUE : Boolean.FALSE;
        } else {
            return Boolean.FALSE;
        }
    }

    public void setPrefixProviderNumber(Character prefixProviderNumber) {
        this.prefixProviderNumber = prefixProviderNumber;
    }

    public Boolean isPrefixProviderNumber() {
        if (null != this.prefixProviderNumber) {
            return this.prefixProviderNumber.compareTo('T') == 0 ? Boolean.TRUE : Boolean.FALSE;
        } else {
            return Boolean.FALSE;
        }
    }

    public void setPrefixPatientNumber(Character prefixPatientNumber) {
        this.prefixPatientNumber = prefixPatientNumber;
    }

    public Boolean isPrefixPatientNumber() {
        if (null != this.prefixPatientNumber) {
            return this.prefixPatientNumber.compareTo('T') == 0 ? Boolean.TRUE : Boolean.FALSE;
        } else {
            return Boolean.FALSE;
        }
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDbPswd() {
        return dbPswd;
    }

    public void setDbPswd(String dbPswd) {
        this.dbPswd = dbPswd;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public Character getClientProcessor() {
        return clientProcessor;
    }

    public void setClientProcessor(Character clientProcessor) {
        this.clientProcessor = clientProcessor;
    }

    public Character getPasswordEncrypted() {
        return passwordEncrypted;
    }

    public void setPasswordEncrypted(Character passwordEncrypted) {
        this.passwordEncrypted = passwordEncrypted;
    }

    public Boolean isPasswordEncrypted() {
        return getPasswordEncrypted().equals('T');
    }

    public ClientGrouping getClientGrouping() {
        return ClientGrouping;
    }

    public void setClientGrouping(ClientGrouping clientGrouping) {
        ClientGrouping = clientGrouping;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientInterop that = (ClientInterop) o;

        if (clientCode != null ? !clientCode.equals(that.clientCode) : that.clientCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return clientCode != null ? clientCode.hashCode() : 0;
    }
}
