package com.docmatter.ims.service;

import java.util.List;

public class MembershipService implements IMembershipService{
    @Override
    public boolean isMemberOf(int entityIdToQuery, int entityIdQueriedAgainst) {
        return false;
    }

    @Override
    public List<Integer> getChildren(int entityId) {
        return null;
    }
}
