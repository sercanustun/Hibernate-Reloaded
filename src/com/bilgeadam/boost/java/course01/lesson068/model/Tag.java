package com.bilgeadam.boost.java.course01.lesson068.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Tag {
	private long   id;
	private String tag;
}
