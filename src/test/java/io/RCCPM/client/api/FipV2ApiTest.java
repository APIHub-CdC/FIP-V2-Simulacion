package io.RCCPM.client.api;

import io.RCCPM.client.ApiClient;
import io.RCCPM.client.model.RequestDatosGenerales;
import io.RCCPM.client.model.ResponseScore;
import okhttp3.OkHttpClient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

@Ignore
public class FipV2ApiTest {
    private final FipV2Api api = new FipV2Api();

    private Logger logger = LoggerFactory.getLogger(FipV2Api.class.getName());
    private ApiClient apiClient = null;
    private String xApiKey = "your api key";


    @Before
    public void Setup() {
        this.apiClient = api.getApiClient();
        this.apiClient.setBasePath("https://services.circulodecredito.com.mx");
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        apiClient.setHttpClient(okHttpClient);
    }
    @Test
    public void devuelveelScoreFINTECHTest() throws Exception {

        String xApiKey = this.xApiKey;

        Object body = null;
        RequestDatosGenerales requestDatosGenerales = new RequestDatosGenerales();
        requestDatosGenerales.setPrimerNombre("");
        requestDatosGenerales.setApellidoPaterno("");
        requestDatosGenerales.setApellidoMaterno("");
        requestDatosGenerales.setFechaNacimiento("");
        requestDatosGenerales.setDireccion("");
        requestDatosGenerales.setColoniaPoblacion("");
        requestDatosGenerales.setCiudad("");
        requestDatosGenerales.setEstado("");
        requestDatosGenerales.setPais("");
        requestDatosGenerales.setDelegacionMunicipio("");
        requestDatosGenerales.setCp("");
        requestDatosGenerales.setRfc("");
        requestDatosGenerales.setCurp("");
        requestDatosGenerales.setFolioOtorgante("");

        String contentType = "application/json";

        ResponseScore response = api.devuelveelScoreFINTECH(xApiKey, requestDatosGenerales, contentType);
        Assert.assertNotNull(response);
        logger.info(String.valueOf(response));
    }
    
}
