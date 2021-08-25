package processica_test_task.service;

import processica_test_task.data_stats.Request;

public interface RequestService {

    Request save(Request request);

    Request findById(Integer id);
}
