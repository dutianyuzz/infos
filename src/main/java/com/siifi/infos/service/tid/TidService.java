package com.siifi.infos.service.tid;

import com.siifi.infos.entity.Tid;

public interface TidService {
    Tid findByIdTid(int tid);
    int editTid(Tid tid);
}
