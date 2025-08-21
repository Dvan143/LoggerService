package org.dmitriyprojects.bankapploggingservice.logs;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WrongPasswordLog extends LogParent {

    public WrongPasswordLog(HttpServletRequest req) {
        from = "Admin panel login page";
        body = "From ip address: " + req.getRemoteAddr();
    }

    public WrongPasswordLog(HttpServletRequest req, String additionalInfo) {
        from = "Admin panel login page";
        body = "From ip address: " + req.getRemoteAddr();
        this.additionalInfo = additionalInfo;
    }
}
