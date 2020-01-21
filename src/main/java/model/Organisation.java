package model;

import java.time.LocalDate;
import java.util.ArrayList;


public class Organisation {
    private long id;
    private String code;
    private String name_full;
    private String name_short;
    private String inn;
    private CompanyType company_type;
    private String ogrn;
    private LocalDate egrul_date;
    private Country country;
    private String fio_head;
    private String address;
    private String phone;
    private String e_mail;
    private String www;
    private String is_resident;
    private ArrayList<Security> securities;

    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getFullName() {
        return name_full;
    }

    public String getShortName() {
        return name_short;
    }

    public String getInn() {
        return inn;
    }

    public CompanyType getCompanyType() {
        return company_type;
    }

    public String getOgrn() {
        return ogrn;
    }

    public LocalDate getEgrulDate() {
        return egrul_date;
    }

    public Country getCountry() {
        return country;
    }

    public String getHeadFio() {
        return fio_head;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return e_mail;
    }

    public String getWww() {
        return www;
    }

    public String isResident() {
        return is_resident;
    }

    public ArrayList<Security> getSecurities() {
        return securities;
    }

    @Override
    public String toString() {
        return "Organisation{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name_full='" + name_full + '\'' +
                ", name_short='" + name_short + '\'' +
                ", inn='" + inn + '\'' +
                ", company_type=" + company_type +
                ", ogrn='" + ogrn + '\'' +
                ", egrul_date='" + egrul_date + '\'' +
                ", country=" + country +
                ", fio_head='" + fio_head + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", www='" + www + '\'' +
                ", is_resident='" + is_resident + '\'' +
                ", securities=" + securities +
                "}\n";
    }

    public class CompanyType{
        private long id;
        private String name_short;
        private String name_full;

        public long getId() {
            return id;
        }

        public String getShortName() {
            return name_short;
        }

        public String getFullName() {
            return name_full;
        }

        @Override
        public String toString() {
            return "CompanyType{" +
                    "id=" + id +
                    ", name_short='" + name_short + '\'' +
                    ", name_full='" + name_full + '\'' +
                    '}';
        }
    }

    public class Country{
        private long id;
        private String code;
        private String name;

        public long getId() {
            return id;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Country{" +
                    "id=" + id +
                    ", code='" + code + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
    public class Security{
        private long id;
        private String code;
        private String name_full;
        private String cfi;
        private LocalDate date_to;
        private LocalDate state_reg_date;
        private State state;
        private Currency currency;

        public long getId() {
            return id;
        }

        public String getCode() {
            return code;
        }

        public String getFullName() {
            return name_full;
        }

        public String getCfi() {
            return cfi;
        }

        public LocalDate getDateTo() {
            return date_to;
        }

        public LocalDate getStateRegDate() {
            return state_reg_date;
        }

        public State getState() {
            return state;
        }

        public Currency getCurrency() {
            return currency;
        }

        @Override
        public String toString() {
            return "Security{" +
                    "id=" + id +
                    ", code='" + code + '\'' +
                    ", name_full='" + name_full + '\'' +
                    ", cfi='" + cfi + '\'' +
                    ", date_to='" + date_to + '\'' +
                    ", state_reg_date='" + state_reg_date + '\'' +
                    ", state=" + state +
                    ", currency=" + currency +
                    '}';
        }

        public class State{
            private long id;
            private String name;

            public long getId() {
                return id;
            }

            public String getName() {
                return name;
            }

            @Override
            public String toString() {
                return "State{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        '}';
            }
        }
        public class Currency{
            private long id;
            private String code;
            private String name_short;
            private String name_full;

            public long getId() {
                return id;
            }

            public String getCode() {
                return code;
            }

            public String getShortName() {
                return name_short;
            }

            public String getFullName() {
                return name_full;
            }

            @Override
            public String toString() {
                return "Currency{" +
                        "id=" + id +
                        ", code='" + code + '\'' +
                        ", name_short='" + name_short + '\'' +
                        ", name_full='" + name_full + '\'' +
                        '}';
            }
        }
    }
}
