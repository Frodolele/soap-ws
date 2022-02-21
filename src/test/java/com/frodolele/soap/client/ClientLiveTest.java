package com.frodolele.soap.client;

import com.frodolele.soap.client.config.CountryClient;
import com.frodolele.soap.client.config.CountryClientConfig;
import com.frodolele.soap.client.gen.Currency;
import com.frodolele.soap.client.gen.GetCountryResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CountryClientConfig.class, loader = AnnotationConfigContextLoader.class)
public class ClientLiveTest {

    @Autowired
    CountryClient client;

    @Test
    public void givenCountryService_whenCountryPoland_thenCapitalIsWarsaw() {
        GetCountryResponse response = client.getCountry("Poland");
        assertEquals("Warsaw", response.getCountry().getCapital());
    }

    @Test
    public void givenCountryService_whenCountrySpain_thenCurrencyEUR() {
        GetCountryResponse response = client.getCountry("Spain");
        assertEquals(Currency.EUR, response.getCountry().getCurrency());
    }
}
