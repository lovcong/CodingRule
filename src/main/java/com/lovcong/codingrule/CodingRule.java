package com.lovcong.codingrule;

import com.lovcong.codingrule.abstracts.IRuleSegment;

import java.util.ArrayList;
import java.util.List;

public class CodingRule {

    public CodingRule() {
        segments = new ArrayList<IRuleSegment>();
    }

    List<IRuleSegment> segments;

    public void AddSegment(IRuleSegment segment) {
        segments.add(segment);
    }

    public String GenerateCode() {
        StringBuilder sb = new StringBuilder();
        for (var segment : segments) {
            sb.append(segment.GeneratePart());
        }
        return sb.toString();
    }


}
