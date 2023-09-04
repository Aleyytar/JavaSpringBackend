package com.example.ReactDilrb.request.forposts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostCreateRequesy {
	Long id;
	String text;
	String title;
	Long userId;

}
