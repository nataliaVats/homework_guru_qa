package tests.homework_3.SelenideAndAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Issue implements Serializable {
    private String author = "MikeTikhonov";
    private String title = "First Issue";
    private String body = "QA guru";
    private String repesitoryName = "MyTestRepository";
    private String labels = "bug";


    public void setNumber(long number) {
        this.number = number;
    }

    private long number;

    public long getNumber() {
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

    public String getRepesitoryName() {
        return repesitoryName;
    }

    public String getAuthor() {
        return author;
    }
}
