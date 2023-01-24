package com.dummy.myerp.model.bean.comptabilite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CompteComptableTest {

    CompteComptable compteComptableUnderTest;
    List<CompteComptable> compteComptableList = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        // create 5 comptes comptables for tests
        for (int i = 0; i < 5; i++){
            compteComptableUnderTest = new CompteComptable();
            compteComptableUnderTest.setLibelle("QQ");
            compteComptableUnderTest.setNumero(i+1);
            compteComptableList.add(compteComptableUnderTest);
        }
    }

    @Test
    public void shouldReturnCompteComptableIfPresent_whenGetByNumero() {
        // GIVEN already initialized
        int compteComptableNumberSearched = 1;

        // WHEN
        CompteComptable result = CompteComptable.getByNumero(compteComptableList,compteComptableNumberSearched);

        // THEN
        assertThat(result.getNumero()).isEqualTo(compteComptableNumberSearched);
    }

    @Test
    public void shouldNotReturnCompteComptableIfNotPresent_whenGetByNumero() {
        // GIVEN already initialized
        int compteComptableNumberSearched = 10;

        // WHEN
        CompteComptable result = CompteComptable.getByNumero(compteComptableList,compteComptableNumberSearched);

        // THEN
        assertThat(result).isEqualTo(null);
    }

    @Test
    public void shouldReturnStringValueOfCompteComptable_whenToString (){
        // GIVEN already initialize

        // WHEN
        String result = compteComptableList.get(0).toString();

        // THEN
        assertThat(result).isEqualTo("CompteComptable{numero=1, libelle='QQ'}");
    }
}