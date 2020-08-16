package homework_3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkingIssue implements Serializable {

    private static final String BASE_URL = "https://github.com/";
    private static final String OWNER_REPOSITORY = "MikeTikhonov";
    private static final String AUTHOR = "MikeTikhonov";
    private static final String TITLE = "First Issue";
    private static final String BODY = "QA guru";
    private static final String REPOSITORY_NAME = "MyTestRepository";
    private static final String LABELS = "bug";
    private static int NUMBER;

    public static void setNUMBER(int NUMBER) {
        WorkingIssue.NUMBER = NUMBER;
    }

    public static int getNUMBER() {
        return NUMBER;
    }

    public static String getLabels() {
        return LABELS;
    }

    public static String getTitle() {
        return TITLE;
    }

    public static String getBody() {
        return BODY;
    }

    public static String getRepositoryName() {
        return REPOSITORY_NAME;
    }

    public static String getAuthor() {
        return AUTHOR;
    }

    public static String getOwnerRepository() {
        return OWNER_REPOSITORY;
    }

    public static String getBaseUrl() {
        return BASE_URL;
    }
}
