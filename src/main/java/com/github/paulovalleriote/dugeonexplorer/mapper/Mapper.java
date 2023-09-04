package com.github.paulovalleriote.dugeonexplorer.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

public class Mapper {
  private static ModelMapper modelMapper = new ModelMapper();

  public static <O, D> D parseObject(O origin, Class<D> destination) {
    return modelMapper.map(origin, destination);
  }

  public static <O, D> List<D> parseObjectsList(List<O> origin, Class<D> destination) {
    List<D> destinationObjects = new ArrayList<>();

    for (O o : origin) {
      destinationObjects.add(modelMapper.map(o, destination));
    }

    return destinationObjects;
  }
}
