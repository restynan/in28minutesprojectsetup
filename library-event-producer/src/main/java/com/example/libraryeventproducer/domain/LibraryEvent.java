package com.example.libraryeventproducer.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LibraryEvent {
   private Integer libraryEventId;
   private LibraryEventType libraryEventType;
   private Book book;

}
