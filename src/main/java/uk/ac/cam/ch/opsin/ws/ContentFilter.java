/****************************************************************************
* Copyright (C) 2011 Daniel Lowe
*
* This file is part of the OPSIN Web Service
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
* 
* A copy of the GNU General Public License version 3 is included in LICENSE.GPL
***************************************************************************/
package uk.ac.cam.ch.opsin.ws;

import org.restlet.data.MediaType;
import org.restlet.data.Preference;

import java.util.List;

import org.restlet.Request;
import org.restlet.Response;
import org.restlet.routing.Filter;

public class ContentFilter extends Filter {
	
	@Override
	protected int beforeHandle(Request request, Response response) {
		String path = request.getResourceRef().getPath();
		List<Preference<MediaType>> acceptedMediaTypes = request.getClientInfo().getAcceptedMediaTypes();
		if (path.endsWith(".no2d.cml")) {
			acceptedMediaTypes.clear();
			acceptedMediaTypes.add(new Preference<MediaType>(OpsinResource.TYPE_NO2DCML));
			request.getResourceRef().setPath(path.substring(0, path.length() - 9));
		}
		else if (path.endsWith(".cml")) {
			acceptedMediaTypes.clear();
			acceptedMediaTypes.add(new Preference<MediaType>(OpsinResource.TYPE_CML));
			request.getResourceRef().setPath(path.substring(0, path.length() - 4));
		}
		else if (path.endsWith(".json")) {
			acceptedMediaTypes.clear();
			acceptedMediaTypes.add(new Preference<MediaType>(OpsinResource.TYPE_JSON));
			request.getResourceRef().setPath(path.substring(0, path.length() - 5));
		}
		else if (path.endsWith(".png")) {
			acceptedMediaTypes.clear();
			acceptedMediaTypes.add(new Preference<MediaType>(MediaType.IMAGE_PNG));
			request.getResourceRef().setPath(path.substring(0, path.length() - 4));
		}
		else if (path.endsWith(".inchi")) {
			acceptedMediaTypes.clear();
			acceptedMediaTypes.add(new Preference<MediaType>(OpsinResource.TYPE_INCHI));
			request.getResourceRef().setPath(path.substring(0, path.length() - 6));
		}
		else if (path.endsWith(".stdinchi")) {
			acceptedMediaTypes.clear();
			acceptedMediaTypes.add(new Preference<MediaType>(OpsinResource.TYPE_STDINCHI));
			request.getResourceRef().setPath(path.substring(0, path.length() - 9));
		}
		else if (path.endsWith(".stdinchikey")) {
			acceptedMediaTypes.clear();
			acceptedMediaTypes.add(new Preference<MediaType>(OpsinResource.TYPE_STDINCHIKEY));
			request.getResourceRef().setPath(path.substring(0, path.length() - 12));
		}
		else if (path.endsWith(".smi")) {
			acceptedMediaTypes.clear();
			acceptedMediaTypes.add(new Preference<MediaType>(OpsinResource.TYPE_SMILES));
			request.getResourceRef().setPath(path.substring(0, path.length() - 4));
		}
		else if (path.endsWith(".svg")) {
			acceptedMediaTypes.clear();
			acceptedMediaTypes.add(new Preference<MediaType>(MediaType.IMAGE_SVG));
			request.getResourceRef().setPath(path.substring(0, path.length() - 4));
		}
		return CONTINUE;
	}

}
