package com.example.museum.data.api;

import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.OkHttpClient;
import okhttp3.tls.Certificates;
import okhttp3.tls.HandshakeCertificates;

public final class CustomTrust {
    // PEM files for root certificates of Comodo and Entrust. These two CAs are sufficient to view
    // https://publicobject.com (Comodo) and https://squareup.com (Entrust). But they aren't
    // sufficient to connect to most HTTPS sites including https://godaddy.com and https://visa.com.
    // Typically developers will need to get a PEM file from their organization's TLS administrator.

    X509Certificate cert =
            Certificates.decodeCertificatePem(""
            + "-----BEGIN CERTIFICATE-----\n"
            + "MIIDUzCCAjugAwIBAgIEU1cSljANBgkqhkiG9w0BAQsFADBaMQswCQYDVQQGEwJT\n"
            + "UjEMMAoGA1UECBMDZWVlMQ0wCwYDVQQHEwRuZWtvMQ4wDAYDVQQKEwVuZXN0bzEO\n"
            + "MAwGA1UECxMFbmVzdG8xDjAMBgNVBAMTBW1pbGFuMB4XDTIwMDUyNDE0NTcyNVoX\n"
            + "DTMwMDUyMjE0NTcyNVowWjELMAkGA1UEBhMCU1IxDDAKBgNVBAgTA2VlZTENMAsG\n"
            + "A1UEBxMEbmVrbzEOMAwGA1UEChMFbmVzdG8xDjAMBgNVBAsTBW5lc3RvMQ4wDAYD\n"
            + "VQQDEwVtaWxhbjCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAMMNhWC+\n"
            + "Bs/EiokAFUQx77FPuu4fNFxEr7esUCln5JEGNJxAPpLmFCpQhfUvVD5n03qmsjct\n"
            + "DJO39JcZ4JAeatECtVvKpgcmjGG2FhE/Phjagcc8ebW3mbzc3Z0zHuwfYHNGJqZl\n"
            + "Qw+g0D9ZvfaywqZpdfMSuaHOPN8q9R27Jgy7DfYZfDSNJ3ovH57MeiqNhNtY4kRG\n"
            + "vE7w/SWo/ws4PKrQl5yi1z4R6yP/tcfUA9rezLwZNtkbo2BKDF3d/J5Vy2tG06dj\n"
            + "EEW4AU1sj1+B1zxDwfnA2EQ8LxANR187Zrtg9O5iSWEkoDyPWrmMPjgxXtQY6Eo7\n"
            + "Kk3YcyoM95D4TokCAwEAAaMhMB8wHQYDVR0OBBYEFK/+W3ntuWf6pEEGytV0H31l\n"
            + "45leMA0GCSqGSIb3DQEBCwUAA4IBAQCJt8lL9ROl0AouPl/zQTRlj0xnt/MdSPnW\n"
            + "wXqlu9gJdR6xy1enDrpZsjsmjNck+/ixoz79mIWhoRnki7MCxix9x4e0i1Aq5Yj/\n"
            + "xcSHI0Ym91haDmtCZlSicP/iCTx/htyaaXxTUKLSE5/T3L5W1A12dQP5v7OIy45i\n"
            + "Ka7qJXjirWvXYGKrqk3l+OvfnN3Wr0HpD/O9Onh096gTwFRZQotR10F4fF/SE7qp\n"
            + "4a/S4/MsSKnE9iIFSl6ltNXVLUyEeQ8zb1iqZZ+DZ2zsTV9H4//6MZSSxwI0cVqz\n"
            + "45AnYX/EPqCB1osdIUOMwpKZ50SzZxhrhY35MqJ+tX4CWqFmTEsb\n"
            + "-----END CERTIFICATE-----\n");

    final OkHttpClient client;

    public CustomTrust() {
        // This implementation just embeds the PEM files in Java strings; most applications will
        // instead read this from a resource file that gets bundled with the application.

        HandshakeCertificates certificates = new HandshakeCertificates.Builder()
                .addTrustedCertificate(cert)
                // Uncomment if standard certificates are also required.
                //.addPlatformTrustedCertificates()
                .build();



//        client.setHostnameVerifier(new HostnameVerifier() {
//            @Override
//            public boolean verify(String hostname, SSLSession session) {
//                return true;
//            }
//        });

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });

        client = new OkHttpClient.Builder()
                .hostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String hostname, SSLSession session) {
                        return true;
                    }
                })
                .sslSocketFactory(certificates.sslSocketFactory(), certificates.trustManager())
                .build();
    }

    public OkHttpClient getClient() {
        return client;
    }
}
