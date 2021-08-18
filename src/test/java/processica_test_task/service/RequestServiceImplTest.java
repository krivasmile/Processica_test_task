package processica_test_task.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import processica_test_task.data_stats.Request;
import processica_test_task.data_stats.Stats;
import processica_test_task.repos.RequestRepository;
import processica_test_task.service.impl.RequestServiceImpl;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class RequestServiceImplTest {
    @Autowired
    private RequestServiceImpl requestServiceImpl;
    @Autowired
    RequestRepository requestRepository;

    private Request request;
    private Stats stats1;
    private Stats stats2;
    private Stats stats3;

    {
        request = new Request();
        request.setPayload("....test 787 ?? test yes job --- job");
        request.setStatsList(RequestServiceImpl.getStatsList(request));

        stats1 = new Stats();
        stats1.setRequest(request);
        stats1.setWord("yes");
        stats1.setEntry(1);

        stats2 = new Stats();
        stats2.setRequest(request);
        stats2.setWord("test");
        stats2.setEntry(2);

        stats3 = new Stats();
        stats3.setRequest(request);
        stats3.setWord("job");
        stats3.setEntry(2);
    }

    @Test
    void save() {
        int id = requestServiceImpl.save(request);
        Request requestFromDb = requestServiceImpl.findById(id);
        Assertions.assertNotNull(requestFromDb);
    }

    @Test
    void findById() {
        int id = requestServiceImpl.save(request);
        Request requestFromDB = requestServiceImpl.findById(id);

        Assertions.assertEquals(request.getId(), requestFromDB.getId());
        Assertions.assertEquals(request.getPayload(), requestFromDB.getPayload());
        Assertions.assertEquals(requestFromDB.getStatsList().size(), request.getStatsList().size());

        Request requestNull = requestServiceImpl.findById(10000);
        Assertions.assertNull(requestNull);
    }

    @Test
    void getStatsList() {
        List<Stats> actualStatsList = RequestServiceImpl.getStatsList(request);
        List<Stats> expectedStatsList = new ArrayList<>();

        expectedStatsList.add(stats1);
        expectedStatsList.add(stats2);
        expectedStatsList.add(stats3);

        Assertions.assertEquals(expectedStatsList.size(), actualStatsList.size());

        for (int i = 0; i < expectedStatsList.size(); i++){
            Assertions.assertEquals(expectedStatsList.get(i).getWord(), actualStatsList.get(i).getWord());
            Assertions.assertEquals(expectedStatsList.get(i).getEntry(), actualStatsList.get(i).getEntry());
        }
    }
}