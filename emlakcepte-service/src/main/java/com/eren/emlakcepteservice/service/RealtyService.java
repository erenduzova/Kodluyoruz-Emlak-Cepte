package com.eren.emlakcepteservice.service;

import com.eren.emlakcepteservice.converter.RealtyConverter;
import com.eren.emlakcepteservice.entity.PublicationRight;
import com.eren.emlakcepteservice.entity.Realty;
import com.eren.emlakcepteservice.entity.User;
import com.eren.emlakcepteservice.entity.enums.RealtyKind;
import com.eren.emlakcepteservice.entity.enums.RealtyStatus;
import com.eren.emlakcepteservice.entity.enums.RealtyType;
import com.eren.emlakcepteservice.repository.PublicationRepository;
import com.eren.emlakcepteservice.repository.RealtyRepository;
import com.eren.emlakcepteservice.request.RealtyRequest;
import com.eren.emlakcepteservice.request.RealtyUpdateRequest;
import com.eren.emlakcepteservice.response.ProvinceResponse;
import com.eren.emlakcepteservice.response.RealtyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RealtyService {

    @Autowired
    private RealtyRepository realtyRepository;

    @Autowired
    private PublicationRepository publicationRepository;

    @Autowired
    private RealtyConverter realtyConverter;

    @Autowired
    private UserService userService;

    // Create Realty
    public RealtyResponse create(RealtyRequest realtyRequest) {
        User user = userService.getById(realtyRequest.getUserId());
        Realty newRealty = realtyConverter.convert(realtyRequest, user);
        realtyRepository.save(newRealty);
        return realtyConverter.convert(newRealty);
    }

    // Get All Realty
    public List<RealtyResponse> getAllRealtyResponse() {
        return realtyConverter.convert(realtyRepository.findAll());
    }

    // Get Realty By Id
    public Realty getById(Integer realtyId) {
        return realtyRepository.findById(realtyId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Realty not found with this id: " + realtyId));

    }

    // Get User's All Realty
    public List<RealtyResponse> getUserAll(Integer userId) {
        List<Realty> allRealty = userService.getAllRealty(userId);
        return realtyConverter.convert(allRealty);
    }

    // Get User's Active Realty
    public List<RealtyResponse> getUserActive(Integer userId) {
        User user = userService.getById(userId);
        List<Realty> activeRealty = realtyRepository.findRealtyByStatusAndUser(RealtyStatus.ACTIVE, user);
        return realtyConverter.convert(activeRealty);
    }

    // Get User's Passive Realty
    public List<RealtyResponse> getUserPassive(Integer userId) {
        User user = userService.getById(userId);
        List<Realty> passiveRealty = realtyRepository.findRealtyByStatusAndUser(RealtyStatus.PASSIVE, user);
        return realtyConverter.convert(passiveRealty);
    }

    // Get Realty By Province
    public List<Realty> getAllByProvince(String searchedProvince) {
        return realtyRepository.findAllByProvince(searchedProvince);
    }
    // Get Realty By District
    public List<Realty> getAllByDistrict(String searchedDistrict) {
        return realtyRepository.findAllByDistrict(searchedDistrict);
    }

    // Get Realty By Province And Realty Type ( SALE, RENT )
    public List<Realty> getProvinceRealtyCountByType(String province, RealtyType type) {
        return realtyRepository.findAllByProvinceAndRealtyType(province, type);
    }

    // Get Realty By Province And Realty Kind ( HOUSE, LAND )
    public List<Realty> getProvinceRealtyCountByKind(String province, RealtyKind kind) {
        return realtyRepository.findAllByProvinceAndRealtyKind(province, kind);
    }

    // Get Realty By Province, Realty Kind ( HOUSE, LAND ) And Realty Type ( SALE, RENT )
    public List<Realty> getProvinceRealtyCountByKindAndType(String province, RealtyKind kind, RealtyType type) {
        return realtyRepository.findAllByProvinceAndRealtyKindAndType(province, kind, type);
    }

    // Get Province Display ( 10 Realty )
    public List<RealtyResponse> getProvinceDisplay(String province) {
        List<Realty> display = realtyRepository.findAllByProvince(province).stream().limit(10).toList();
        return realtyConverter.convert(display);
    }

    // Get Realty Info of the Province ( Counts of the Realty Types )
    // Edit Here For Clean Code
    public ProvinceResponse getProvinceResponse(String province) {
        Integer realtyCount = getAllByProvince(province).size();
        Integer saleRealtyCount = getProvinceRealtyCountByType(province, RealtyType.SALE).size();
        Integer saleHouseCount = getProvinceRealtyCountByKindAndType(province, RealtyKind.HOUSE, RealtyType.SALE).size();
        Integer saleLandCount = getProvinceRealtyCountByKindAndType(province, RealtyKind.LAND, RealtyType.SALE).size();
        Integer rentRealtyCount = getProvinceRealtyCountByType(province, RealtyType.RENT).size();
        Integer rentHouseCount = getProvinceRealtyCountByKindAndType(province, RealtyKind.HOUSE, RealtyType.RENT).size();
        Integer rentLandCount = getProvinceRealtyCountByKindAndType(province, RealtyKind.LAND, RealtyType.RENT).size();

        ProvinceResponse provinceResponse = new ProvinceResponse();

        provinceResponse.setProvince(province);
        provinceResponse.setRealtyCount(realtyCount);
        provinceResponse.setSaleRealtyCount(saleRealtyCount);
        provinceResponse.setSaleHouseCount(saleHouseCount);
        provinceResponse.setSaleLandCount(saleLandCount);
        provinceResponse.setRentRealtyCount(rentRealtyCount);
        provinceResponse.setRentHouseCount(rentHouseCount);
        provinceResponse.setRentLandCount(rentLandCount);

        return provinceResponse;
    }

    public RealtyResponse update(Integer realtyId, RealtyUpdateRequest realtyUpdateRequest) {
        Realty realty = getById(realtyId);
        // Update
        if (realtyUpdateRequest.getTitle() != null && realtyUpdateRequest.getTitle().length() > 0) {
            realty.setTitle(realtyUpdateRequest.getTitle());
        }
        if (realtyUpdateRequest.getType() != null) {
            realty.setType(realtyUpdateRequest.getType());
        }
        if (realtyUpdateRequest.getDistrict() != null && realtyUpdateRequest.getDistrict().length() > 0) {
            realty.setDistrict(realtyUpdateRequest.getDistrict());
        }
        if (realtyUpdateRequest.getProvince() != null && realtyUpdateRequest.getProvince().length() > 0) {
            realty.setProvince(realtyUpdateRequest.getProvince());
        }
        realtyRepository.save(realty);
        return realtyConverter.convert(realty);
    }

    // Publish Realty
    public RealtyResponse publish(Integer realtyId) {
        Realty realty = getById(realtyId);
        activate(realty);
        return realtyConverter.convert(realty);
    }

    // Activate Realty
    public void activate(Realty realty) {
        if (RealtyStatus.ACTIVE.equals(realty.getStatus())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Realty already published");
        }
        if (haveTime(realty)) {
            realty.setStatus(RealtyStatus.ACTIVE);
            realtyRepository.save(realty);
        } else {
            // Look for unused publication right and use if exist
            usePublicationRight(realty);
        }
    }

    // Does Realty have time for publication
    public boolean haveTime(Realty realty) {
        return realty.getPublicationEnding().isAfter(LocalDateTime.now());
    }

    // Use Publication Right
    public void usePublicationRight(Realty realty) {
        User user = realty.getUser();
        // Does user have unused publication right
        Optional<PublicationRight> unUsedPublicationRight = user.getPublicationRightList().stream()
                .filter(publicationRight1 -> !publicationRight1.isUsed()).findFirst();
        if (unUsedPublicationRight.isPresent()) {
            // Use Publication Right
            PublicationRight usePublicationRight = unUsedPublicationRight.get();
            realty.setPublicationEnding(LocalDateTime.now().plusDays(usePublicationRight.getDays()));
            realty.setStatus(RealtyStatus.ACTIVE);
            usePublicationRight.setUsed(true);
            publicationRepository.save(usePublicationRight);
            realtyRepository.save(realty);
        } else {
            // User has no publication rights
            throw new ResponseStatusException(HttpStatus.PAYMENT_REQUIRED, "Buy Publication Right to publish");
        }

    }

    // Extend Realty Publication
    public RealtyResponse extend(Integer realtyId) {
        Realty realty = getById(realtyId);
        if (RealtyStatus.ACTIVE.equals(realty.getStatus())) {
            usePublicationRight(realty);
        }
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Can't extend publication of non published realty.");
    }

    // Retract Realty Publication ( Set RealtyStatus.PASSIVE )
    public RealtyResponse retract(Integer realtyId) {
        Realty realty = getById(realtyId);
        if (RealtyStatus.PASSIVE.equals(realty.getStatus())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Realty is already in Passive status.");
        }
        realty.setStatus(RealtyStatus.PASSIVE);
        realtyRepository.save(realty);
        return realtyConverter.convert(realty);
    }
}
