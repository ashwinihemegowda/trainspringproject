package com.torryharris.DAO;

import com.torryharris.api.Train;

import java.util.List;

public interface TrainDAO {
    List<Train> loadTrains();
    List<Train> loadTrains(int trainNo);

    }

