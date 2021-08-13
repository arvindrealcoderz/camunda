package com.realcoderz.services;

import java.util.List;

import com.realcoderz.entity.Client;
public interface ISuperAdminService {
		public Integer saveRecored(Client admin);
		public List<Client>  getAllClient();

}
