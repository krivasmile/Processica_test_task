package processica_test_task.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import processica_test_task.data_stats.Request;
import processica_test_task.data_stats.Stats;
import processica_test_task.repos.RequestRepository;
import processica_test_task.service.RequestService;

import java.util.*;

@Service
public class RequestServiceImpl implements RequestService {
    private final RequestRepository requestRepository;

    @Autowired
    public RequestServiceImpl(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public Integer save(Request request){
        request.setStatsList(getStatsList(request));
        requestRepository.save(request);
        return request.getId();

    }
    @Override
    public Request findById(Integer id){
        return requestRepository.findById(id).orElse(null);
    }

    public static List<Stats> getStatsList(Request request){
        List<Stats> statsList = new ArrayList<>();

        Map<String, Integer> mapStats = new TreeMap<>(Collections.reverseOrder());
        Arrays.stream(request.getPayload().split("[^A-Za-zА-Яа-я]+"))
                .forEach(s -> mapStats.put(s, mapStats.getOrDefault(s, 0)+1));

        for (Map.Entry<String, Integer> word : mapStats.entrySet()){
            if (!word.getKey().equals("")){
            Stats stat = new Stats();
            stat.setWord(word.getKey());
            stat.setEntry(word.getValue());
            stat.setRequest(request);
            statsList.add(stat);
            }
        }
        return statsList;
    }
}

