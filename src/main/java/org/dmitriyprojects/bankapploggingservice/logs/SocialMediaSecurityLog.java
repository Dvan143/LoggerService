package org.dmitriyprojects.bankapploggingservice.logs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SocialMediaSecurityLog extends LogParent {
    public SocialMediaSecurityLog(String body) {
        from = "SocialMedia Security Service";
        this.body = body;
    }

    public SocialMediaSecurityLog(String body, String additionalInfo) {
        from = "SocialMedia Security Service";
        this.body = body;
        this.additionalInfo = additionalInfo;
    }
}
