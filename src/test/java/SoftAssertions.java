import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertions {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void softAssertionsPageShouldContainJUnit5Example() {
        //  Открыть страницу Selenide в Github
        open("/selenide/selenide");

        //переходим в раздел Wiki
        $("#wiki-tab").click();

        //находим страницу SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions");

        //открываем страницу SoftAssertions
        $(byText("SoftAssertions")).click();

        //проверяем пример кода для JUnit5
        $("#wiki-body").shouldHave(text(
                "@ExtendWith({SoftAssertsExtension.class})\n" +
                        "class Tests {\n" +
                        "  @Test\n" +
                        "  void test() {\n" +
                        "    Configuration.assertionMode = SOFT;\n" +
                        "    open(\"page.html\");\n" +
                        "\n" +
                        "    $(\"#first\").should(visible).click();\n" +
                        "    $(\"#second\").should(visible).click();\n" +
                        "  }\n" +
                        "}"));

    }
}
