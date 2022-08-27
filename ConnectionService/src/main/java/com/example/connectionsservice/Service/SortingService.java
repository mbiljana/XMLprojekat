package com.example.connectionsservice.Service;
import lombok.NoArgsConstructor;

import java.util.*;
@NoArgsConstructor
public class SortingService implements Comparator<DateItem>{

        @Override
        public int compare(DateItem a, DateItem b){
            return a.date.compareTo(b.date);
        }


    }

