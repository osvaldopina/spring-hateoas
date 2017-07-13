/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.hateoas.hal.forms;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Greg Turnquist
 */
final class HalFormsUtils {

	public static Object toHalFormsDocument(Object object, ObjectMapper objectMapper) {

		if (object == null) {
			return null;
		}

		if (object instanceof ResourceSupport) {
			ResourceSupport rs = (ResourceSupport) object;

			List<Link> links = new ArrayList<Link>();
			List<Template> templates = new ArrayList<Template>();

			process(rs, links, templates, objectMapper);

			return HalFormsDocument.halFormsDocument()
				.links(links)
				.templates(templates)
				.build();
		} else { // bean
			return object;
		}
	}

	private static void process(ResourceSupport resource, List<Link> links, List<Template> templates,
								ObjectMapper objectMapper) {

	}
}
