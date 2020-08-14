package tests.homework_3.SelenideAndAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Issue implements Serializable {
    private String author = "MikeTikhonov";
    private String title = "First Issue";
    private String body = "QA guru";
    private String repositoryName = "MyTestRepository";
    private String labels = "bug";
    private int number;

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getLabels() {
        return labels;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public String getAuthor() {
        return author;
    }
}
