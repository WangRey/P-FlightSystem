package org.sicnusc.team_project.service;

public interface MailService {
    void sendSimpleMail(String To);
    Boolean verification(String email, String unverifiedCode);
}