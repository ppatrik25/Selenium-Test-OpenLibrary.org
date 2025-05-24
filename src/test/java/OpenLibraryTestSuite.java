import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import tests.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    CookieHandlerTest.class,
    StaticPageTest.class,
    StaticPagesArrayTest.class,
    FormSubmissionTest.class,
    FillTextareaTest.class,
    FileUploadHandlerTest.class,
    LogoutPageTest.class
})
public class OpenLibraryTestSuite {
}