package com.server;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;


public class WarningMessage {
    
        private ZonedDateTime sent;
        private String nick;
        private double latitude;
        private double longitude;
        private String dangertype;

        public long getSent() {
                return sent.toInstant().toEpochMilli();
        }
        public void setSent(long epoch) {
                sent =  ZonedDateTime.ofInstant(Instant.ofEpochMilli(epoch), ZoneOffset.UTC);
        }
        public String getNick() {
                return nick;
        }
        public void setNick(String nick) {
                this.nick = nick;
        }

        public Double getLatitude() {
                return latitude;
        }
        public void setLatitude(Double latitude) {
                this.latitude = latitude;
        }

        public Double getLongitude() {
                return longitude;
        }
        public void setLongitude(Double longitude) {
                this.longitude = longitude;
        }

        public String getDangertype() {
        return dangertype;
        }
        public void setDangertype(String dangertype) {
        this.dangertype = dangertype;
        }
}
