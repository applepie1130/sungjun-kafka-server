package com.kafka.model.entity;


import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TempEntity {
	
    private Integer id;

    private LocalDateTime regDate;
    
}