package me.screw.javademostudy.datastructure.linkedlist;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
public class ListNode {

    @Getter
    private Integer number;
    @Getter @Setter
    private ListNode next;

}
