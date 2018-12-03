package com.lumbela.SerenityCucumberTemplate.steps.serenity;

import com.lumbela.SerenityCucumberTemplate.pages.WiktionaryPage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class UserSteps {

    WiktionaryPage wiktionaryPage;

    @Step
    public void enters(String keyword) {
        wiktionaryPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        wiktionaryPage.lookup_terms();
    }

    @Step
    public void should_see_definition(String definition) {
        assertThat(wiktionaryPage.getDefinitions(), hasItem(containsString(definition)));
    }

    @Step
    public void is_on_the_home_page() {
        wiktionaryPage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }
}