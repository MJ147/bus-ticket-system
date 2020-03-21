package pl.connectis.programator.model;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public enum ValidUntil {

    _20M(LocalDateTime.now().plusMinutes(20)),
    _24H(LocalDateTime.now().plusHours(24)),
    _30D(LocalDateTime.now().plusDays(30));

    public LocalDateTime validUntil;

    ValidUntil() {
    }

    ValidUntil(LocalDateTime validUntil) {
        this.validUntil = validUntil;
    }

    public void setValidUntil(LocalDateTime validUntil) {
        this.validUntil = validUntil;
    }

    public String toStringFormatted() {
        if(this.equals(ValidUntil._20M)) {
            return "20 minutowy";
        } else if (this.equals(ValidUntil._24H)) {
            return "24 godzinny";
        } else {
            return "30 dniowy";
        }
    }

}

