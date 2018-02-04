package fashionette.automation.tech.extentions;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class BaseModel {
    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }
}
