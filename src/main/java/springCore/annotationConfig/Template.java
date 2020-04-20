package springCore.annotationConfig;

import org.springframework.stereotype.Service;

@Service
public class Template {
    private String templateNumber;

    public String getTemplateNumber() {
        return templateNumber;
    }

    public void setTemplateNumber(String templateNumber) {
        this.templateNumber = templateNumber;
    }

    @Override
    public String toString() {
        return "Template{" +
                "templateNumber='" + templateNumber + '\'' +
                '}';
    }
}
