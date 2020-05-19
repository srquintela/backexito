package org.springframework.samples.exito.usuario;

import org.slf4j.ILoggerFactory;
import org.springframework.samples.exito.system.JwtTokenUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.validation.Valid;
import java.util.*;

import static org.springframework.samples.exito.usuario.Respuesta.respuesta;

@Controller
class UsuarioController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private static final String VIEWS_USUARIO_CREAR_O_MODIFICAR = "usuarios/crearOModificarUsuario";

	private final UsuarioRepository usuarios;

	private final DecisionRepository decisionRepository;

	private final IdentidadRepository identidadRepository;

	private final PersonalidadRepository personalidadRepository;

	private final RazonamientoRepository razonamientoRepository;

	private final CarreraRepository carreraRepository;

	UsuarioController(UsuarioRepository usuarios, DecisionRepository decisionRepository,
			IdentidadRepository identidadRepository, PersonalidadRepository personalidadRepository,
			RazonamientoRepository razonamientoRepository, CarreraRepository carreraRepository) {
		this.usuarios = usuarios;
		this.decisionRepository = decisionRepository;
		this.identidadRepository = identidadRepository;
		this.personalidadRepository = personalidadRepository;
		this.razonamientoRepository = razonamientoRepository;
		this.carreraRepository = carreraRepository;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@GetMapping("/usuarios/new")
	public String initCreationForm(Map<String, Object> model) {
		Usuario usuario = new Usuario();
		model.put("usuario", usuario);
		return VIEWS_USUARIO_CREAR_O_MODIFICAR;
	}

	@PostMapping("/usuarios/new")
	public String processCreationForm(@Valid Usuario usuario, BindingResult result) {
		if (result.hasErrors()) {
			return VIEWS_USUARIO_CREAR_O_MODIFICAR;
		}
		else {
			this.usuarios.save(usuario);
			return "redirect:/usuarios/" + usuario.getId();
		}
	}

	@GetMapping("/usuarios/encontrar")
	public String initFindForm(Map<String, Object> model) {
		model.put("usuario", new Usuario());
		return "usuarios/encontrarUsuarios";
	}

	@GetMapping("/usuarios")
	public String processFindForm(Usuario usuario, BindingResult result, Map<String, Object> model) {

		// permite que el campo de busqueda vacio retorne todos los resultados
		if (usuario.getUsername() == null) {
			usuario.setUsername(""); // cadena vacia retorna toda la lista
		}

		// encontrar usuarios por username
		Collection<Usuario> results = this.usuarios.buscarPorUsername(usuario.getUsername());
		if (results.isEmpty()) {
			// no hay usuarios con el apellido ingresado
			result.rejectValue("username", "notFound", "not found");
			return "usuarios/encontrarUsuarios";
		}
		else if (results.size() == 1) {
			// 1 usuario found
			usuario = results.iterator().next();
			return "redirect:/usuarios/" + usuario.getId();
		}
		else {
			// varios usuario
			model.put("selections", results);
			return "usuarios/usuariosLista";
		}
	}

	@GetMapping("/usuarios/{usuarioId}/edit")
	public String initUpdateUsuarioForm(@PathVariable("usuarioId") int usuarioId, Model model) {
		Usuario usuario = this.usuarios.findById(usuarioId);
		model.addAttribute(usuario);
		return VIEWS_USUARIO_CREAR_O_MODIFICAR;
	}

	@PostMapping("/usuarios/{usuarioId}/edit")
	public String processUpdateUsuarioForm(@Valid Usuario usuario, BindingResult result,
			@PathVariable("usuarioId") int usuarioId) {
		if (result.hasErrors()) {
			return VIEWS_USUARIO_CREAR_O_MODIFICAR;
		}
		else {
			usuario.setId(usuarioId);
			this.usuarios.save(usuario);
			return "redirect:/usuarios/{usuarioId}";
		}
	}

	@GetMapping("/usuarios/{usuarioId}")
	public ModelAndView showUsuario(@PathVariable("usuarioId") int usuarioId) {
		ModelAndView mav = new ModelAndView("usuarios/usuarioDetalles");
		Usuario usuario = this.usuarios.findById(usuarioId);
		mav.addObject(usuario);
		return mav;
	}

	@GetMapping("/usuarios/mostrarusuario/{username}")
	public @ResponseBody Usuario mostrarUsuario(@PathVariable("username") String username) {
		Usuario resultado = this.usuarios.buscarPorUser(username);
		return resultado;
	}

	@PutMapping("/usuarios/editarusuario")
	public @ResponseBody Usuario editarUsuario(@RequestBody Usuario usuario) {
		Usuario resultado = this.usuarios.buscarPorUser(usuario.getUsername());
		resultado.setNombre(usuario.getNombre());
		resultado.setUeducativa(usuario.getUeducativa());
		resultado.setApellidos(usuario.getApellidos());
		resultado.setFechanac(usuario.getFechanac());
		resultado.setSexo(usuario.getSexo());
		resultado.setGrado(usuario.getGrado());
		resultado.setNivel(usuario.getNivel());
		resultado.setDpto(usuario.getDpto());
		resultado.setProvincia(usuario.getProvincia());
		resultado.setLocalidad(usuario.getLocalidad());
		resultado.setDescripcion(usuario.getDescripcion());
		this.usuarios.save(resultado);
		return resultado;
	}

	@PostMapping("/usuarios/login")
	public @ResponseBody Respuesta login(@RequestBody AuthClienteRequest authClienteRequest) {
		Usuario resultado = this.usuarios.buscarPorUser(authClienteRequest.getUsername());
		Respuesta respuesta = new Respuesta();
		if (resultado == null) {
			return respuesta("NOK", "No existe usuario", null);
		}
		else if (resultado.getPassword().equals(authClienteRequest.getPassword())) {
			Map<Object, Object> model = new HashMap<>();
			model.put("username", resultado.getUsername());
			JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
			model.put("token", jwtTokenUtil.generateToken(resultado));
			model.put("passwordHabilitado", "true");
			return respuesta("OK", "Ingreso exitoso", model);
		}
		return respuesta;
	}

	/* Modulo Decision */
	@PostMapping("/usuarios/editardecision")
	public @ResponseBody Decision editarDecision(@RequestBody Decision decision) {
		String deusuario = decision.getUsuariodec();
		String defuente = decision.getFuente();
		Decision debusca = this.decisionRepository.buscarDecisionPorUserYFuente(deusuario, defuente);
		if (debusca == null) {
			this.decisionRepository.save(decision);
		}
		ArrayList<Decision> test = this.decisionRepository.buscarDecisionPorUser(decision.getUsuariodec());
		log.info("Objetos Guardados: " + test.size());
		return decision;
	}

	@GetMapping("/usuarios/contardecision/{username}")
	public @ResponseBody Integer contarDecision(@PathVariable("username") String username) {
		ArrayList<Decision> test = this.decisionRepository.buscarDecisionPorUser(username);
		log.info("Objetos Guardados: " + test.size());
		return test.size();
	}

	/* Modulo Razonamiento */
	@PostMapping("/usuarios/editarrazon")
	public @ResponseBody Razonamiento editarRazon(@RequestBody Razonamiento razonamiento) {
		Razonamiento razbusca = this.razonamientoRepository.buscarPorUser(razonamiento.getUsuarioraz());
		if (razbusca == null) {
			this.razonamientoRepository.save(razonamiento);
		}
		log.info("Objeto Razon Guardado para usuario: %", razonamiento.getUsuarioraz());
		return razonamiento;
	}

	/* Modulo identidad */
	@PostMapping("/usuarios/editariden")
	public @ResponseBody Identidad editarIdentidad(@RequestBody Identidad identidad) {
		Identidad idebusca = this.identidadRepository.buscarPorUser(identidad.getUsuario());
		if (idebusca == null) {
			this.identidadRepository.save(identidad);
		}
		log.info("Objeto Guardado para usuario: ", identidad.getUsuario());
		return identidad;
	}

	/* Modulo Personalidad */
	@PostMapping("/usuarios/editarperso")
	public @ResponseBody Personalidad editarPersonalidad(@RequestBody Personalidad personalidad) {
		Personalidad perbusca = this.personalidadRepository.buscarPorUser(personalidad.getUsuarioper());
		if (perbusca == null) {
			this.personalidadRepository.save(personalidad);
		}
		log.info("Objetos Guardados para usuario: ", personalidad.getUsuarioper());
		return personalidad;
	}

	@GetMapping("/usuarios/mostrarperso/{username}")
	public @ResponseBody Personalidad mostrarPersonalidad(@PathVariable("username") String username) {
		return this.personalidadRepository.buscarPorUser(username);
	}

	/* Modulo Carrera */
	@PostMapping("/usuarios/obtienecarreras")
	public @ResponseBody ArrayList<Carrera> obtieneCarreras(@RequestBody Carrera carrera) {
		String areabuscar = carrera.getArea();
		String dptobuscar = carrera.getDpto();
		String pagobuscar = carrera.getPago();
		ArrayList<Carrera> listaCarreras = this.carreraRepository.buscaCarreras(areabuscar, dptobuscar, pagobuscar);
		log.info("Objeto buscado: ", carrera.toString());
		log.info("Objetos encontrados", listaCarreras.size());
		return listaCarreras;
	}

}
