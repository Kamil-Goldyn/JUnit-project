package org.testing;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class AccountTest {

    @Test
    void newAccountShouldNotBeActiveAfterCreation() {
        //given
        Account newAccount = new Account();
        //then
        assertFalse(newAccount.isActive());
        assertThat(newAccount.isActive(),is(false));
    }

    @Test
    void accountShouldBeActiveAfterActivation() {
        //given
        Account newAccount = new Account();
        //when
        newAccount.activate();
        //then
        assertTrue(newAccount.isActive());
        assertThat(newAccount.isActive(),is(true));
    }

    @Test
    void newlyCreatedAccountShouldNotHaveDefaultDeliveryAddress() {
        //given
        Account account = new Account();
        //when
        Address address = account.getDefaultDeliveryAddress();
        //then
        assertNull(address);
        assertThat(address,is(nullValue()));
    }

    @Test
    void defaultDeliveryAddressShouldNotBeNullAfterBeingSet() {
        //given
        Address address = new Address("Krakowska","67c");
        Account account = new Account();
        account.setDefaultDeliveryAddress(address);
        //when
        Address defaultAdress = account.getDefaultDeliveryAddress();
        //then
        assertNotNull(defaultAdress);
        assertThat(defaultAdress,is(notNullValue()));
    }

    @RepeatedTest(25)
    void newAccountWithNotNullAddressShouldBeActive() {
        //given
        Address address = new Address("Puławska","46/6");
        //when
        Account account = new Account(address);
        //then
        assumingThat(address != null, () -> {
            assertTrue(account.isActive());
        });
    }
}
