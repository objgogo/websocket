package xyz.websocket.poker.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class InsertPokerResponse {
    String id;
    String name;
    LocalDateTime regDt;

}
