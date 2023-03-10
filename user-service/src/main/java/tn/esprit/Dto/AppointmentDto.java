package tn.esprit.Dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.Entitys.Account;
import tn.esprit.Entitys.AppointmentStatus;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;


@Builder
@AllArgsConstructor
@ToString
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppointmentDto {
    long id;
    String reason;
    Date createdAt ;
    String comments;
    boolean is_first_visit ;
    LocalDate appointmentDate;
    LocalTime appointmentStartTime;
    LocalTime appointmentEndTime;
    AppointmentStatus appointmentStatus;
}
