package org.dmitriyprojects.bankapploggingservice.logs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BankAppSecurityLog extends LogParent {

    public BankAppSecurityLog(String body, String additionalInfo) {
        from = "Bankapp Security Service";
        this.body = body;
        this.additionalInfo = additionalInfo;
    }
    public BankAppSecurityLog(String body) {
        from = "Bankapp Security Service";
        this.body = body;
    }
}
